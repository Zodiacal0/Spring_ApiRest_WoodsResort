package com.lte.woods_resort.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.exceptions.RoomsException;
import com.lte.woods_resort.models.Rooms;
import com.lte.woods_resort.services.IRoomsService;

import lombok.var;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController // http://locallhost:8087/wdr/v1/Rooms
@RequestMapping("wdr/v1/Rooms")
public class RoomsController {

    private static final Logger logger = LoggerFactory.getLogger(RoomsController.class);

    @Autowired
    private IRoomsService iRoomsService;

    @GetMapping("/list-rooms")
    public List<Rooms> listRooms() {
        var rooms = iRoomsService.listRooms();
        rooms.forEach((rooms2 -> logger.info(rooms.toString())));
        return rooms;
    }
    
    @PostMapping("/add-rooms")
    public Rooms addRooms(@RequestBody Rooms rooms) {
        logger.info("room created");    
        return iRoomsService.saveRooms(rooms);
    }

    @GetMapping("/search-rooms/{id}")
    public ResponseEntity<Rooms> searchRooms(@RequestParam String id_rooms) {
        Rooms rooms = iRoomsService.findRooms(id_rooms);
        if (rooms == null) {
            throw new RoomsException("this room not exist");
        }
        return ResponseEntity.ok(rooms);
    }

    @PutMapping("/update-room/{id}")
    public ResponseEntity<Rooms> updateRoom(@PathVariable String id_rooms, @RequestBody Rooms roomsEdit) {
        Rooms room = iRoomsService.findRooms(id_rooms);
        if(room == null){
            throw new RoomsException("this id not exist");
        }
        if (iRoomsService.listRooms().stream().anyMatch(r -> r.getId_rooms() == roomsEdit.getId_rooms() && roomsEdit.getId_rooms() != id_rooms)) {
            throw new RoomsException("this id alredy exist");
        }

        room.setCapacity(roomsEdit.getCapacity());
        room.setCommodities(roomsEdit.getCommodities());
        room.setNumber(roomsEdit.getNumber());
        room.setPrice(roomsEdit.getPrice());
        room.setState(roomsEdit.getState());
        room.setType(roomsEdit.getType());

        return ResponseEntity.ok(room);
    }

    @DeleteMapping("delete-rooms/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteRoom(@PathVariable String id_rooms){
        Rooms rooms = iRoomsService.findRooms(id_rooms);
        if (rooms == null) {
            throw new RoomsException("this id not exist");
        }

        iRoomsService.deleteRooms(rooms);
        Map<String, Boolean> ans = new HashMap<>();
        ans.put("deleted", true);
        
        return ResponseEntity.ok(ans);
    }
    
    

}

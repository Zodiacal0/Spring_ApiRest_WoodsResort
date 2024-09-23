package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.exceptions.RoomsException;
import com.lte.woods_resort.models.Rooms;
import com.lte.woods_resort.repository.RoomsRespository;

@Service
public class RoomsService implements IRoomsService {

    @Autowired
    private RoomsRespository roomsRespository;

    @Override
    public List<Rooms> listRooms() {
        return roomsRespository.findAll();
    }

    @Override
    public Rooms findRooms(Long id_rooms) {
        Rooms rooms = roomsRespository.findById(id_rooms).orElse(null);
        return rooms;
    }

    @Override
    public Rooms saveRooms(Rooms rooms) {
        if (roomsRespository.existsById(rooms.getIdRooms())) {
            throw new RoomsException("this rooms already exist");
        }
        return roomsRespository.save(rooms);
    }

    @Override
    public void deleteRooms(Rooms rooms) {
        roomsRespository.delete(rooms);
    }

}

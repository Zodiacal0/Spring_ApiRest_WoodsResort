package com.lte.woods_resort.controllers;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.exceptions.HotelsExceptions;
import com.lte.woods_resort.models.Hotels;
import com.lte.woods_resort.models.Reservations;
import com.lte.woods_resort.services.HotelsService;

@RestController
@RequestMapping("wdr/v1/Hotels")

public class HotelController {

    private Hotels hotel;

    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelsService hotelsService;

    @GetMapping("/list-Hotels")

    public List<Hotels> listHotels() {
        var hotel = hotelsService.listHoteles();
        hotel.forEach((hotelss -> logger.info(hotel.toString())));
        return hotel;
    }

    @GetMapping("/search-Hotel/{id}")

    public ResponseEntity<Hotels> searchHotels(@PathVariable Long idHotel) {
        this.hotel = hotelsService.searchHotels(idHotel);
        if (this.hotel == null)
            throw new HotelsExceptions("the hotel was not found");
        return ResponseEntity.ok(this.hotel);
    }

    @PostMapping("/save-Hotels")

    public Hotels saveHotels(@RequestBody Hotels hotels) {
        logger.info("New hotel has been added");
        return hotelsService.saveHotels(hotels);
    }

    @PutMapping("/edit-Hotels/{id}")
    public ResponseEntity<Hotels> editHotels(@PathVariable Long idHotel, @RequestBody Hotels hotels) {
        this.hotel = hotelsService.searchHotels(idHotel);
        if (this.hotel == null)
            throw new HotelsExceptions("the hotel was not found");
        this.hotel.setName(hotels.getName());
        this.hotel.setAddress(hotels.getAddress());
        this.hotel.setServices(hotels.getServices());
        this.hotel.setPhoneNumber(hotels.getPhoneNumber());
        this.hotel.setEmail(hotels.getEmail());
        hotelsService.saveHotels(this.hotel);
        return ResponseEntity.ok(this.hotel);
    }

    @DeleteMapping("/delete-Hotels/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHotels(@PathVariable Long idHotel) {
        this.hotel = hotelsService.searchHotels(idHotel);
        if (this.hotel == null)
            throw new HotelsExceptions("the hotel was not found");
        hotelsService.removeHotels(this.hotel);

        Map<String, Boolean> confirmation = new HashMap<>();
        confirmation.put("hotel removed successfully", true);
        return ResponseEntity.ok(confirmation);
    }

}

package com.lte.woods_resort.controllers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lte.woods_resort.exceptions.ReservationsExceptions;
import com.lte.woods_resort.models.Reservations;
import com.lte.woods_resort.services.IReservationsServices;

@RestController //http://localhost:8080/wdr/v1/Reservations

@RequestMapping("wdr/v1/Reservations")

public class ReservationsController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationsController.class);

    @Autowired
    private IReservationsServices iReservationsServices;

    @GetMapping("/list-reservation")
    public List<Reservations> listReservations(){
        var reservation = iReservationsServices.listReservations();
        reservation.forEach((reservation2 -> logger.info(reservation.toString())));
        return reservation;
    }

    @PostMapping("/add-reservation")
    public Reservations addReservations(@RequestBody Reservations reservations){
        logger.info("Reservation added successfully!");
        return iReservationsServices.saveReservation(reservations);
    }


    @GetMapping("/list-reservation/{id}")
    public ResponseEntity<Reservations> editReservation (@PathVariable Long id_reservation, @RequestBody Reservations reservationEdit){
        Reservations reservations = iReservationsServices.findReservation(id_reservation);
        if(reservations == null)
            throw new ReservationsExceptions("This reservation does not exist, check again");

        reservations.setStarDate(reservationEdit.getStarDate());
        reservations.setEndDate(reservationEdit.getEndDate());
        reservations.setIdRooms(reservationEdit.getIdRooms());
        reservations.setIdUser(reservationEdit.getIdUser());
        reservations.setId_Hotel(reservationEdit.getId_Hotel());
        iReservationsServices.saveReservation(reservations);
        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping("/list-reservation/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteReservation(@PathVariable Long id_reservation){
        Reservations reservations = iReservationsServices.findReservation(id_reservation);
        if (reservations == null)
            throw new ReservationsExceptions("This reservation does not exist, check again");

            iReservationsServices.deleteReservation(reservations);

            Map<String, Boolean> answer = new HashMap<>();
            answer.put("Reservation successfully deleted", true);

            return ResponseEntity.ok(answer);
    }

}

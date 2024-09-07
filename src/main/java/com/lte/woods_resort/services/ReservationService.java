package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Reservations;
import com.lte.woods_resort.repositories.ReservationsRepository;

@Service

public class ReservationService implements IReservationsServices{

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public List<Reservations> listReservations() {
        return reservationsRepository.findAll();
    }

    @Override
    public Reservations findReservation(Long id_reservation) {
        Reservations reservations = reservationsRepository.findById(id_reservation).orElse(null);
        return reservations;
    }

    @Override
    public Reservations saveReservation(Reservations reservations) {
        return reservationsRepository.save(reservations);
    }

    @Override
    public void deleteReservation(Reservations reservations) {
        reservationsRepository.delete(reservations);
    }

}

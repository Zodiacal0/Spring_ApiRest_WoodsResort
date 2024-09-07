package com.lte.woods_resort.services;
import java.util.List;

import com.lte.woods_resort.models.Reservations;

public interface IReservationsServices {
    public List<Reservations>  listReservations();

    public Reservations findReservation(Long id_reservation);

    public Reservations saveReservation(Reservations reservations);

    public void deleteReservation(Reservations reservations);
}

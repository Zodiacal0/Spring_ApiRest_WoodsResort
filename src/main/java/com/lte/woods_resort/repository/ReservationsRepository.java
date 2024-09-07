package com.lte.woods_resort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lte.woods_resort.models.Reservations;

public interface ReservationsRepository extends JpaRepository <Reservations, Long>{

}

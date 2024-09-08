package com.lte.woods_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lte.woods_resort.models.Payments;

public interface PaymentsRespository extends JpaRepository<Payments, Long> {

}

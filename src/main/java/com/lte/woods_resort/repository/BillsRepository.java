package com.lte.woods_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lte.woods_resort.models.Bills;

public interface BillsRepository extends JpaRepository <Bills, Long> {

}

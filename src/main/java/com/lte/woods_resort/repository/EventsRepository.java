package com.lte.woods_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lte.woods_resort.models.Events;

public interface EventsRepository extends JpaRepository<Events, Long>{

    
}
package com.lte.woods_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lte.woods_resort.models.Users;

public interface UserRepository extends JpaRepository<Users, String> {
    
    Users findByEmail(String email);
    
    Users findByUserName(String userName); 
}

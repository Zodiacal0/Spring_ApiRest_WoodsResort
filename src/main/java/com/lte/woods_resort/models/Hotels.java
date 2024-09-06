package com.lte.woods_resort.models;

import java.io.Serializable;
import java.util.List;

import com.lte.woods_resort.utils.star;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name="Hotels")
@NoArgsConstructor
public class Hotels implements  Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_Hotel;  
    private String name;
    private String address;    
    private String services;
    private String phoneNumber;
    private String email;

    @Column(name ="star")
    private star star;

    @OneToMany(mappedBy = "id_rooms")
    private List<Rooms> rooms;

    @OneToMany(mappedBy = "idReservation")
    private List<Reservations> reservations;


}

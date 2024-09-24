package com.lte.woods_resort.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rooms")
public class Rooms implements Serializable {
    
    @Id
    @Column(name = "id_rooms")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRooms;

    @Column(unique = true, name = "number")
    private int number;

    @Column(unique = true)
    private String type;

    private Double price;
    private int capacity;
    private String commodities;
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")  
    private Hotels hotel; 

    @ManyToOne
    @JoinColumn(name = "id_reservation", referencedColumnName = "id_reservation")
    private Reservations reservation;

    @Override
    public String toString() {
        return "Rooms{" +
                "idRooms=" + idRooms +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", commodities='" + commodities + '\'' +
                ", state='" + state + '\'' +
                ", hotel=" + (hotel != null ? hotel.getIdHotel() : "null") +
                ", reservation=" + (reservation != null ? reservation.getIdReservation() : "null") +
                '}';
    }

}

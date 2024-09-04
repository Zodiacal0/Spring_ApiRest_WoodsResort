package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

// Crea de forma automatica la DB con sus atributos
@Entity

// Genera automáticamente los métodos getters y setters, el método toString()
@Data

// Nombre de la tabla 
@Table(name = "reservations")

// Genera automáticamente un método toString() que incluye todos los campos de la clase

public class Reservations implements Serializable {

    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name = "star_date")
    private Date starDate;

    @Column(name = "end_date")
    private Date endDate;
    
    @ManyToOne
    @Column(name = "id_user")
    private Users idUser;

    @OneToMany
    @Column(name = "id_rooms")
    private Rooms idRooms;
    
}
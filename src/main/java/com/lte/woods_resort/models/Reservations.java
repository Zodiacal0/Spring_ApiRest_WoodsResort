package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    private Long id_reservation;
    private Date star_date;
    private Date end_date;

    private Long id_user;
    
    private Long id_rooms;
    
}
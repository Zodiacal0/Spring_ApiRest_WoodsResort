package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "reservations")
public class Reservations implements Serializable {

    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name = "star_date")
    private String starDate;

    @Column(name = "end_date")
    private String endDate;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Users id_user;

}
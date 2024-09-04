package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Date starDate;

    @Column(name = "end_date")
    private Date endDate;
    
    @ManyToOne
    private Users idUser;

    @OneToMany
    private List<Rooms> idRooms;
    
    @ManyToOne
    private Hotels id_Hotel;
}
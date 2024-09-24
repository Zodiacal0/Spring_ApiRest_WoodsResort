package com.lte.woods_resort.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private String starDate;

    @Column(name = "end_date")
    private String endDate;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Users id_user;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "reservation")
    private List<Rooms> rooms;

    
    @Override
    public String toString() {
        return "Reservations{" +
                "idReservation=" + idReservation +
                ", starDate='" + starDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id_user=" + (id_user != null ? id_user.getIdUser() : "null") +
                ", rooms=" + (rooms != null ? rooms.size() : 0) +
                '}';
    }

}
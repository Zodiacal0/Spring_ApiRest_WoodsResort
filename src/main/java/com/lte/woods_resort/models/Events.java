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
@Table(name = "events")
public class Events implements Serializable{
    @Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event;
    private String name_event;
    private String event_description;
    private String date;

    
    @ManyToOne
    @JoinColumn(name = "id_hotel",referencedColumnName = "id_hotel")
    private Hotels hotel;


    @ManyToOne
    @JoinColumn (name = "id_user",referencedColumnName = "id_user")
    private Users user;
    
    @Override
    public String toString() {
        return "Events{" +
                "id_event=" + id_event +
                ", name_event='" + name_event + '\'' +
                ", event_description='" + event_description + '\'' +
                ", date='" + date + '\'' +
                ", hotel=" + (hotel != null ? hotel.getIdHotel() : "null") +
                ", user=" + (user != null ? user.getIdUser() : "null") +
                '}';
    }

}

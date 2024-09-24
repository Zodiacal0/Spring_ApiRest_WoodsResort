package com.lte.woods_resort.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lte.woods_resort.utils.StarRating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "hotels")
@NoArgsConstructor
public class Hotels implements Serializable {
    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHotel; 

    private String name;
    private String address;
    private String services;
    private String phoneNumber;
    private String email;

    @Column(name = "star")
    @Enumerated(EnumType.STRING)
    private StarRating star;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "hotel") 
    private List<Rooms> rooms;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "hotel") 
    private List<Events> events;

    
    @Override
    public String toString() {
        return "Hotels{" +
                "idHotel=" + idHotel +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", services='" + services + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", star=" + (star != null ? star.name() : "null") +
                '}';
    }

}

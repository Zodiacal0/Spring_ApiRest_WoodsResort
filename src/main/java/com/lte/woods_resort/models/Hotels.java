package com.lte.woods_resort.models;

import java.io.Serializable;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
=======
import java.util.List;
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb

import com.lte.woods_resort.utils.star;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.OneToMany;
=======
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
=======
import jakarta.persistence.OneToMany;
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb
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
<<<<<<< HEAD
<<<<<<< HEAD
    private long idHotel;
=======
    private long id_Hotel;
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
=======
    private long idHotel;
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb
    private String name;
    private String address;    
    private String services;
    private String phoneNumber;
    private String email;

    @Column(name ="star")
    private star star;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb
    @OneToMany(mappedBy = "id_rooms")
    private List<Rooms> rooms;

    @OneToMany(mappedBy = "idReservation")
    private List<Reservations> reservations;


<<<<<<< HEAD
=======
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
=======
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb
}

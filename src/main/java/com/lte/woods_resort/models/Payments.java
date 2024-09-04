package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table (name="Payments")
public class Payments implements Serializable{
    @Id
    @Column(name="idPago")
    
    private Long  id_Pago;
    private  int  amount;
    private Date  paymentDate;

    //@ManyToOne
    //@OneToMany
    //private Reservation Reservation;

    //@ManyToOne
    //@OneToMany
    //private User User;

    //@ManyToOne
    //@OneToMany
    //private Payment_Method Payment_Method;
}

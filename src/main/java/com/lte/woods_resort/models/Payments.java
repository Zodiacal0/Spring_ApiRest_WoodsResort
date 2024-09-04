package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="Payments")
public class Payments implements Serializable{
    @Id
    @Column(name="idPago")
    private Long id_Pago;
    
    private int amount;
    private Date paymentDate;

    @OneToOne
    private Reservations Reservation;

    @ManyToOne
    private Users User;

    @OneToOne
    private Payment_Methods Payment_Method;
}

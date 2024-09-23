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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payments")
public class Payments implements Serializable {
    
    @Id
    @Column(name = "id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private double amount;

    @Column(name = "payment_date")
    private String paymentDate;

    @OneToOne
    @JoinColumn(name = "id_reservation", referencedColumnName = "id_reservation")
    private Reservations reservation;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private Users user;

    @OneToOne
    @JoinColumn(name = "id_payment_methods", referencedColumnName = "id_payment_methods")
    private Payment_Methods paymentMethod;

    @OneToOne(mappedBy = "payment")
    private Bills bill;

}

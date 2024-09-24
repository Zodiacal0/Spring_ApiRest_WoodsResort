package com.lte.woods_resort.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bills")
public class Bills {
    
    @Id
    @Column(name = "id_invoice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInvoice;

    @Column(name = "numero_factura")
    private Long numeroFactura;

    @Column(name = "issue_date")
    private Date issueDate;

    @OneToOne
    @JoinColumn(name = "id_payment")
    private Payments payment;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Users user;

    
    @Override
    public String toString() {
        return "Bills{" +
                "idInvoice=" + idInvoice +
                ", numeroFactura=" + numeroFactura +
                ", issueDate=" + issueDate +
                ", payment=" + (payment != null ? payment.getIdPago() : "null") +
                ", user=" + (user != null ? user.getIdUser() : "null") +
                '}';
    }

}

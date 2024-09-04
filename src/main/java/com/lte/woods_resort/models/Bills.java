package com.lte.woods_resort.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

// Crea de forma automatica la DB con sus atributos
@Entity

// Genera automáticamente los métodos getters y setters, el método toString()
@Data

// Nombre de la tabla 
@Table(name = "Bills")

// Genera automáticamente un método toString() que incluye todos los campos de la clase

public class Bills {
    
    @Id
    @Column(name = "id_invoice")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idInvoice;

    @Column(name = "numero_factura")
    private Long numeroFactura;

    @Column(name = "issue_date")
    private Date issueDate;

    @OneToMany
    @Column(name = "id_payment")
    private Payments idPayment;
    
    @OneToOne
    @Column(name = "id_user")
    private Users idUser;




}

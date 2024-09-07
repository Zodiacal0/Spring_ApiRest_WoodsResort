package com.lte.woods_resort.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Bills")
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
    private Payments idPayment;
    
    @OneToMany(mappedBy = "id_Pago")  
    private List<Payments> id_Pago;
    
    @OneToOne
    @JoinColumn(name = "id_user")
    private Users idUser;

}

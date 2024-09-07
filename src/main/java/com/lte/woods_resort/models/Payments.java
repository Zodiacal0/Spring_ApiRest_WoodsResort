<<<<<<< HEAD
package com.lte.woods_resort.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
=======
import jakarta.persistence.Table;

@Entity

>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
@Table (name="Payments")
public class Payments implements Serializable{
    @Id
    @Column(name="idPago")
<<<<<<< HEAD
    private Long id_Pago;
    
    private int amount;
    private Date paymentDate;

    @OneToOne
    private Reservations Reservation;

    @ManyToOne
    private Users User;

    @OneToOne
    private Payment_Methods Payment_Method;
=======
    
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
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
}
=======
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
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb

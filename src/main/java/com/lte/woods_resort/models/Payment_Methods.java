package com.lte.woods_resort.models;

import java.io.Serializable;

import com.lte.woods_resort.utils.TypeOfPaymentMethods;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment_metods")
public class Payment_Methods implements Serializable{

    @Id
    @Column(name = "id_payment_methods", unique = true)
    private String idPaymentMethods;

    @Column(name = "type_of_payment_methods")
    private TypeOfPaymentMethods typeOfPaymentMethods;

<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
=======
}
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb

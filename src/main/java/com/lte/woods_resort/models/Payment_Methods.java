package com.lte.woods_resort.models;

import java.io.Serializable;

import com.lte.woods_resort.utils.TypeOfPaymentMethods;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment_methods") 
public class Payment_Methods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_methods")
    private Long idPaymentMethods; 

    @Column(name = "type_of_payment_methods")
    @Enumerated(EnumType.STRING)
    private TypeOfPaymentMethods typeOfPaymentMethods;

    @Override
    public String toString() {
        return "Payment_Methods{" +
                "idPaymentMethods=" + idPaymentMethods +
                ", typeOfPaymentMethods=" + (typeOfPaymentMethods != null ? typeOfPaymentMethods.name() : "null") +
                '}';
    }
}

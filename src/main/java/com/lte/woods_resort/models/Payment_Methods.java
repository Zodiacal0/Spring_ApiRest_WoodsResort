package com.lte.woods_resort.models;

import java.io.Serializable;

import com.lte.woods_resort.utils.TypeOfPaymentMethods;
import com.lte.woods_resort.services.EncryptService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "id_payment_methods")
    private String idPaymentMethods;

    @Column(name = "type_of_payment_methods")
    private TypeOfPaymentMethods typeOfPaymentMethods;

    @Column(name = "password_payment_methods")
    private String encryptedPassword;

    public void setPasswordPaymentMethods(String password) {
        this.encryptedPassword = EncryptService.encriptar(password);
    }

    public String getPasswordPaymentMethods() {
        return EncryptService.desencriptar(this.encryptedPassword);
    }

}
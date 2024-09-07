package com.lte.woods_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lte.woods_resort.models.Payment_Methods;

public interface PaymentMethodsRepository  extends JpaRepository<Payment_Methods, String>{
    /*
    Metodos que sean necesarios; a discutir segun el objetivo de esta clase, ya que se puede busccar por 
    tarjeta o por clave tarjeta, hay temas de seguridad a tratar tambien.
    */ 
}

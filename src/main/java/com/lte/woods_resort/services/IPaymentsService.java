package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Payments;

public interface IPaymentsService {

    public List<Payments> listPayments();

    public Payments findPayments(Long id_Pago);
    
    public Payments savePayments(Payments payments);
}

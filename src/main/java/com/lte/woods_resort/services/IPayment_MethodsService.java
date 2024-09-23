package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Payment_Methods;

public interface IPayment_MethodsService {
    public List<Payment_Methods> listPayment_Methods();

    public Payment_Methods choosePayment_Methods(Long idPaymentMethods);

    public Payment_Methods savePayment_Methods(Payment_Methods payment_Methods);

    public void deletePayment_Methods(Payment_Methods payment_Methods);
}

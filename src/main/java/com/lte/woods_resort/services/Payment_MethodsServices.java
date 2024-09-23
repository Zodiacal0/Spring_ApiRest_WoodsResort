package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Payment_Methods;
import com.lte.woods_resort.repository.PaymentMethodsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Payment_MethodsServices implements IPayment_MethodsService {

    @Autowired
    private PaymentMethodsRepository pmRepository;
    @Override
    public List<Payment_Methods> listPayment_Methods() {
        return pmRepository.findAll();
    }

    @Override
    public Payment_Methods choosePayment_Methods(Long idPaymentMethods) {
    return pmRepository.findById(idPaymentMethods)
        .orElseThrow(() -> new EntityNotFoundException("Payment Method not found with id: " + idPaymentMethods));
    }


    @Override
    public  Payment_Methods savePayment_Methods(Payment_Methods payment_Methods) {
        return pmRepository.save(payment_Methods);
    }

    @Override
    public void deletePayment_Methods(Payment_Methods payment_Methods) {
        pmRepository.delete(payment_Methods);
    }

}

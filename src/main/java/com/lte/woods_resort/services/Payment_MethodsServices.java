package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Payment_Methods;
import com.lte.woods_resort.repository.PaymentMethodsRepository;

@Service
public class Payment_MethodsServices implements IPayment_MethodsService {

    @Autowired
    private PaymentMethodsRepository pmRepository;
    @Override
    public List<Payment_Methods> listPayment_Methods() {
        return pmRepository.findAll();
    }

    @Override
    public Payment_Methods choosePayment_Methods(String idPaymentMethods) {
        //return pmRepository.findById(idPaymentMethods).orElse(null);
        //Tarea tarea = tareaRepositorio.findById(idTarea).orElse(null);
        Payment_Methods payM = pmRepository.findById(idPaymentMethods).orElse(null);
        return payM;
        
    }

    @Override
    public void savePayment_Methods(Payment_Methods payment_Methods) {
        pmRepository.save(payment_Methods);
    }

    @Override
    public void deletePayment_Methods(Payment_Methods payment_Methods) {
        pmRepository.delete(payment_Methods);
    }

}

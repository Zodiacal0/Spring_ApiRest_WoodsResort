package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Payments;
import com.lte.woods_resort.repository.PaymentsRespository;

@Service
public class PaymentsService implements IPaymentsService {

    @Autowired
    private PaymentsRespository paymentsRespository;

    @Override
    public List<Payments> listPayments() {
        return paymentsRespository.findAll();
    }

    @Override
    public Payments findPayments(Long id_Pago) {
        Payments payments = paymentsRespository.findById(id_Pago).orElse(null);
        return payments;
    }

    @Override
    public Payments savePayments(Payments payments) {
        return paymentsRespository.save(payments);
    }

}

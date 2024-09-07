package com.lte.woods_resort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Bills;
import com.lte.woods_resort.repository.BillsRepository;

@Service
public class BillsService implements IBillsService {

    @Autowired  
    private BillsRepository billsRepository;

    @Override
    public Bills findBills(Long idInvoice) {
        Bills bills = billsRepository.findById(idInvoice).orElse(null);
        return bills;
    }

    @Override
    public Bills addBills(Bills bills) {
        return billsRepository.save(bills);
    }

    
}

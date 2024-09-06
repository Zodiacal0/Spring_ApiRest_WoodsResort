package com.lte.woods_resort.services;

import com.lte.woods_resort.models.Bills;

public interface IBillsService {

    public Bills findBills(Long idInvoice);
    
    public Bills addBills(Bills bills);
}

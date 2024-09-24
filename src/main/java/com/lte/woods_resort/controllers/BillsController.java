package com.lte.woods_resort.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.exceptions.BillsExceptions;
import com.lte.woods_resort.models.Bills;
import com.lte.woods_resort.services.IBillsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // http://localhost:8087/wdr/v1/bills
@RequestMapping("wdr/v1/bills")
public class BillsController {

    private static final Logger logger = LoggerFactory.getLogger(BillsController.class);

    @Autowired
    private IBillsService ibBillsService;

    @GetMapping("/search-bills/{id}")
    public ResponseEntity<Bills> findBills(@PathVariable Long idInvoice) {
        Bills bills = ibBillsService.findBills(idInvoice);
        if (bills == null) {
            throw new BillsExceptions("this invoice not exist");
        }
        return ResponseEntity.ok(bills);
    }

    @PostMapping("/bills")
    public Bills addBills(@ModelAttribute Bills bills) {
        logger.info("invoice added");
        return ibBillsService.addBills(bills);
    }

    
}

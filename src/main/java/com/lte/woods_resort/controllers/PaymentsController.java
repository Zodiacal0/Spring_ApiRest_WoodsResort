package com.lte.woods_resort.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.exceptions.PaymentsExceptions;
import com.lte.woods_resort.models.Payments;
import com.lte.woods_resort.services.IPaymentsService;

@RestController //http://locallhost:8087/wdr/v1/payments
@RequestMapping("wdr/v1/Payments")
public class PaymentsController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentsController.class);
    
    @Autowired
    private IPaymentsService iPaymentsService;

    @GetMapping("/list-payments")

    public List<Payments> obtenerEmpleado(){
        var payments = iPaymentsService.listPayments();
        payments.forEach((payments2 -> logger.info(payments.toString())));
        return payments;

    }


    @PostMapping("/add-payment")
    public Payments addPayments(@RequestBody Payments payments) {
        logger.info("payment added");
        return iPaymentsService.savePayments(payments);
    }

    @GetMapping("/find-payment/{id}")
    public ResponseEntity<Payments> findPayments(@PathVariable Long id_Pago) {
        Payments payments = iPaymentsService.findPayments(id_Pago);
        if (payments == null)
            throw new PaymentsExceptions("payment not exist");
        return ResponseEntity.ok(payments);
    }
}

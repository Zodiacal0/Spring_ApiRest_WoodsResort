package com.lte.woods_resort.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lte.woods_resort.exceptions.Payment_MethodsException;
import com.lte.woods_resort.models.Payment_Methods;
import com.lte.woods_resort.services.IPayment_MethodsService;

public class Payment_MethodsController {
    private static final Logger logger = LoggerFactory.getLogger(Payment_MethodsController.class);

    @Autowired
    private IPayment_MethodsService iPayment_MethodsService;

     @GetMapping("/list-payM")
    public List<Payment_Methods> listPayment_Methods(){
        var pyM = iPayment_MethodsService.listPayment_Methods();
        pyM.forEach((pyM2 -> logger.info(pyM.toString())));
        return pyM;
    }

    @PostMapping("add-payM")
    public Payment_Methods addPayment_Methods(@RequestBody Payment_Methods pyM) {
        logger.info("Metodo de pago agregado");
        return iPayment_MethodsService.savePayment_Methods(pyM);
    }

    @GetMapping("/choose-payM/{id}")
    public ResponseEntity<Payment_Methods> chooserPaymentMethod(@PathVariable String idPaymentMethods){
        Payment_Methods pyM = iPayment_MethodsService.choosePayment_Methods(idPaymentMethods);
        if(pyM == null)
            throw new Payment_MethodsException("no se encontro el metodo de pago");
        return ResponseEntity.ok(pyM);
    }

    @PutMapping("/edit-payM/{id}")
    public ResponseEntity<Payment_Methods> edtiPaymentMethod(@PathVariable String idPaymentMethods, 
    @RequestBody Payment_Methods editPayment_Methods) {
        Payment_Methods pyM = iPayment_MethodsService.choosePayment_Methods(idPaymentMethods);
        if (pyM == null)
            throw new Payment_MethodsException("El id no existe");
            pyM.setTypeOfPaymentMethods(editPayment_Methods.getTypeOfPaymentMethods());
        iPayment_MethodsService.savePayment_Methods(pyM);
        return ResponseEntity.ok(pyM);
    }
    
    @DeleteMapping("/delete-payM/{id}")
    public ResponseEntity <Map<String, Boolean>> eliminatPaymentMethods(@PathVariable String idPaymentMethods){
        Payment_Methods pyM = iPayment_MethodsService.choosePayment_Methods(idPaymentMethods);
        if (pyM == null)
            throw new Payment_MethodsException("El id no existe");
            iPayment_MethodsService.deletePayment_Methods(pyM);

            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Eliminado", true);

            return ResponseEntity.ok(respuesta);

    }
    
}

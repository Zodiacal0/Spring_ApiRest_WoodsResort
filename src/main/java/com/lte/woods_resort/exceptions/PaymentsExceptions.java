package com.lte.woods_resort.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PaymentsExceptions extends RuntimeException {

    public PaymentsExceptions(String message){
        super(message);
    }

}

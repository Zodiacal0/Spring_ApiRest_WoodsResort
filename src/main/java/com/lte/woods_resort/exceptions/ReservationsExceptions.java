package com.lte.woods_resort.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class ReservationsExceptions extends RuntimeException{
    public ReservationsExceptions(String message){
        super(message);
    }
}

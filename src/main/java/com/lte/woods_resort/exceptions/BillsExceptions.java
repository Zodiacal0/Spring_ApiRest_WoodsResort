package com.lte.woods_resort.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BillsExceptions extends RuntimeException {

<<<<<<< HEAD
    public BillsExceptions(String message){

        super(message);
=======
    public BillsExceptions(String mesagge){

        super(mesagge);
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb

    }
}

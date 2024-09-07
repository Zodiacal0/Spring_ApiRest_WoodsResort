package com.lte.woods_resort.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class HotelsExceptions extends RuntimeException {
    public HotelsExceptions(String message){
        super(message);
    }

}

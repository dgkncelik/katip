package com.dogukancelik.kutuphane.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {
    //TODO: put a logger here
    @ExceptionHandler(NotFound.class)
    public void handleNotFound(NotFound e){
        System.out.println("DEFAULT EXCEPTION HANDLER: "  + e.getMessage());
    }

    @ExceptionHandler(Conflict.class)
    public void handleNotFound(Conflict e){
        System.out.println("DEFAULT EXCEPTION HANDLER: "  + e.getMessage());
    }


}

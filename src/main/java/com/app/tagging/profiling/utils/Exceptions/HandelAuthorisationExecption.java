package com.app.tagging.profiling.utils.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class HandelAuthorisationExecption  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAuthorized.class)
    public ResponseEntity<Object> CategoryFound(Exception ex, WebRequest request){
        return  new ResponseEntity(new MessageExeption(ex.getMessage(),request.getDescription(false),new Date()), HttpStatus.UNAUTHORIZED);

    }
}

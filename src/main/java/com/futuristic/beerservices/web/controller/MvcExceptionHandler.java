package com.futuristic.beerservices.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * created by Aditya on 07-Feb-20
 */
@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException cve) {
        Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
        List<String> errors = new ArrayList<>();
        constraintViolations.forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " +constraintViolation.getConstraintDescriptor());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

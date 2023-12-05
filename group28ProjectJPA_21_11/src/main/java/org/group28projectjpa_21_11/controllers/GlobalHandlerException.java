package org.group28projectjpa_21_11.controllers;


import org.group28projectjpa_21_11.core.validation.IsAlreadyExistException;
import org.group28projectjpa_21_11.core.validation.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    // Обработка NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Обработка NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlerNotFountException(NotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Обработка IsAlreadyExistException
    @ExceptionHandler(IsAlreadyExistException.class)
    public ResponseEntity<String> handlerIsAlreadyExistException(IsAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

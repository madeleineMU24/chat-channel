package com.example.chat_channel;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND) //I_AM_A_TEAPOT som skämt
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException exceptions){
        Map<String,String> errorList = new HashMap<>();

        exceptions.getBindingResult()
                .getFieldErrors()
                .forEach (e -> errorList.put(e.getField(),e.getDefaultMessage()));

        return errorList;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String,String> handleEntityNotFound(EntityNotFoundException entitys) {
        Map<String,String> errorList = new HashMap<>();
        errorList.put("error: ", entitys.getMessage());
        return errorList;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }


}

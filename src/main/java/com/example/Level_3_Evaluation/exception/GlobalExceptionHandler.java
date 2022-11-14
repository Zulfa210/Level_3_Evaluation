package com.example.Level_3_Evaluation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Zulfa Attar
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PositionOccupiedException.class)
    public ResponseEntity positionOccupied(String message){
        return new ResponseEntity(message, HttpStatus.NOT_ACCEPTABLE);
    }
}

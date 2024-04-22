package com.melissa.springboot.error.springbooterror.controllers;
import com.melissa.springboot.error.springbooterror.models.Error;
import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptionController {

  @ExceptionHandler({ArithmeticException.class})
  public ResponseEntity<Error> divisionByZero(Exception ex){
    Error error = new Error();
    error.setDate(new Date());
    error.setError("Error en division en cero");
    error.setMessage(ex.getMessage());
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    //return  ResponseEntity.internalServerError().body(error);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

  }

}

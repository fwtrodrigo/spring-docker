package com.fwtcompany.desafio_uol.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDto> threatNoSuchElementException(NoSuchElementException e) {
        ExceptionDto dto = new ExceptionDto(e.getMessage(), "400");
        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDto> threatIllegalArgumentException(IllegalArgumentException e) {
        ExceptionDto dto = new ExceptionDto(e.getMessage(), "400");
        return ResponseEntity.badRequest().body(dto);
    }
}

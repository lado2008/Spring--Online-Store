package com.example.online_store.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleMethondArgumentException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();

        ExceptionBody exceptionBody = new ExceptionBody();
        List<String> massages = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            massages.add(fieldError.getDefaultMessage());
        }
        exceptionBody.setMessage(massages);
        exceptionBody.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBody);
    }

    @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleResponseStatusException(ResponseStatusException exception) {
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(List.of(exception.getMessage()));
        exceptionBody.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(exception.getStatusCode()).body(exceptionBody);
    }

    @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleRuntimeException(RuntimeException exception) {
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(List.of(exception.getMessage()));
        exceptionBody.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionBody);
    }
}

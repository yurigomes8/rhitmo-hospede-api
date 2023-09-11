package com.rhitmo.rhitmohospedeapi.adapters.web.exception;

import com.rhitmo.rhitmohospedeapi.model.Error;
import com.rhitmo.rhitmohospedeapi.model.ErrorErrorsInner;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RhitmoHospedeHandlerException {

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<Error> handleValidationException(WebExchangeBindException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<ErrorErrorsInner> validationErrors = new ArrayList<>();

        for (var fieldError : bindingResult.getFieldErrors()) {
            var validationError = new ErrorErrorsInner();
            validationError.setCode(fieldError.getCode());
            validationError.setMessage(fieldError.getDefaultMessage());
            validationErrors.add(validationError);
        }

        var error = new Error().code("400").description("Bad Request").errors(validationErrors);
        return ResponseEntity.status(400).body(error);
    }
}

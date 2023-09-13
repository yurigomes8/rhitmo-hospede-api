package com.rhitmo.rhitmohospedeapi.adapters.web.exception;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.HandlerExceptionResponse;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ValidationErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RhitmoHospedeControllerExcepetion {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HandlerExceptionResponse> handleValidationException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<ValidationErrorResponse> validationErrors = new ArrayList<>();

        for (var fieldError : bindingResult.getFieldErrors()) {
            var validationError = new ValidationErrorResponse();
            validationError.setErrorMessage(fieldError.getDefaultMessage());
            validationError.setField(fieldError.getField());
            validationErrors.add(validationError);
        }

        return ResponseEntity.badRequest().body(new HandlerExceptionResponse("400", "Bad Request", validationErrors));
    }

}

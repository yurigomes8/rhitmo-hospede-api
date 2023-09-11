package com.rhitmo.rhitmohospedeapi.adapters.web.exception;

import com.rhitmo.rhitmohospedeapi.model.Error;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RhitmoHospedeControllerExcpetion {

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<Error> dataIntegrityException(DataIntegrityViolationException exception) {
//        var handlerExceptionResponse = new Error(exception., exception.getMessage());
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(handlerExceptionResponse);
//    }
//
//    @ExceptionHandler(BusinessException.class)
//    public ResponseEntity<HandlerExceptionResponse> businessException(BusinessException exception) {
//        var handlerExceptionResponse = new HandlerExceptionResponse(exception.getErrorMessageCode(), exception.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(handlerExceptionResponse);
//    }
//
//    @ExceptionHandler(TechnicalException.class)
//    public ResponseEntity<HandlerExceptionResponse> technicalException(TechnicalException exception) {
//        var handlerExceptionResponse = new HandlerExceptionResponse(exception.getErrorMessageCode(), exception.getMessage());
//        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(handlerExceptionResponse);
//    }
}

package com.rhitmo.rhitmohospedeapi.adapters.web.exception;



import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.HandlerExceptionResponse;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ValidationErrorResponse;
import com.rhitmo.rhitmohospedeapi.core.domain.exception.BusinessException;
import com.rhitmo.rhitmohospedeapi.core.domain.exception.TechnicalException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RhitmoHospedeHandlerException {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<HandlerExceptionResponse> businessException(BusinessException exception) {
        var handlerExceptionResponse = new HandlerExceptionResponse(exception.getErrorMessageCode(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(handlerExceptionResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<HandlerExceptionResponse> technicalException(TechnicalException exception) {
        var handlerExceptionResponse = new HandlerExceptionResponse(exception.getErrorMessageCode(), exception.getErrorMessageCode());
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(handlerExceptionResponse);
    }
}

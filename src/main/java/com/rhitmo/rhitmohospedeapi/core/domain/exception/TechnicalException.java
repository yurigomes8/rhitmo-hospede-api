package com.rhitmo.rhitmohospedeapi.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class TechnicalException {

    private String errorMessageCode;

    public TechnicalException(String message) {
        super();
    }

    public TechnicalException(String message, Throwable cause){
        super();
    }

    public TechnicalException(String message, String errorMessageCode) {
        super();
        this.errorMessageCode = errorMessageCode;
    }

    public TechnicalException(String message, Throwable cause, String errorMessageCode) {
        super();
        this.errorMessageCode = errorMessageCode;
    }

    public String getErrorMessageCode() {
        return errorMessageCode;
    }
}

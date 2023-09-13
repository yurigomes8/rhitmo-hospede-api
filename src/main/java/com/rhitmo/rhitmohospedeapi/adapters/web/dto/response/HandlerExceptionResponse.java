package com.rhitmo.rhitmohospedeapi.adapters.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Setter
@ToString
@NoArgsConstructor
@Data
public class HandlerExceptionResponse {

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("errors")
    private List<ValidationErrorResponse> errors;

    public HandlerExceptionResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public HandlerExceptionResponse(String code, String description, List<ValidationErrorResponse> errors) {
        this.code = code;
        this.description = description;
        this.errors = errors;
    }
}

package com.rhitmo.rhitmohospedeapi.adapters.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationErrorResponse {

    @JsonProperty("field")
    private String field;

    @JsonProperty("errorMessage")
    private String errorMessage;
}

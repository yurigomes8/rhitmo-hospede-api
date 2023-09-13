package com.rhitmo.rhitmohospedeapi.adapters.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostHttpResponseDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("createdAt")
    private Instant createdAt;
}

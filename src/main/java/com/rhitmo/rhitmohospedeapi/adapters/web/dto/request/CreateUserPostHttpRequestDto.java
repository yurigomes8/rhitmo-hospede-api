package com.rhitmo.rhitmohospedeapi.adapters.web.dto.request;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CreateUserPostHttpRequestDto implements Serializable {
    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "email cannot be null")
    @Size(max = 255)
    @NotEmpty(message = "email cannot be empty")
    @NotBlank(message = "email cannot be blank")

    private String email;
    @NotNull(message = "cpf cannot be null")
    @NotEmpty(message = "cpf cannot be empty")
    @NotBlank(message = "cpf cannot be blank")
    private String cpf;
}
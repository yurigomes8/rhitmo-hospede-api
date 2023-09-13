package com.rhitmo.rhitmohospedeapi.adapters.web.dto.request;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Room}
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CreateRoomPostHttpRequestDto implements Serializable {
    @NotNull(message = "amount cannot be null")
    @Positive(message = "amount must be positive")
    private BigDecimal amount;

    @NotNull(message = "description cannot be null")
    @Size(max = 255)
    @NotEmpty(message = "description cannot be empty")
    @NotBlank(message = "description cannot be blank")
    private String description;
}
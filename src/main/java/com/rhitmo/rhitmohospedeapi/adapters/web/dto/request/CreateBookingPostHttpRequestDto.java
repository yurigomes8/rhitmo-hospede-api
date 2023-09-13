package com.rhitmo.rhitmohospedeapi.adapters.web.dto.request;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Booking}
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CreateBookingPostHttpRequestDto implements Serializable {

    @NotNull(message = "checkIn cannot be null")
    @Future(message = "checkIn must be in the future")
    private Instant checkIn;

    @NotNull(message = "checkOut cannot be null")
    @Future(message = "checkOut must be in the future")
    private Instant checkOut;

    @NotNull(message = "roomId cannot be null")
    private int roomId;

    @NotNull(message = "roomId cannot be null")
    private int userId;
}
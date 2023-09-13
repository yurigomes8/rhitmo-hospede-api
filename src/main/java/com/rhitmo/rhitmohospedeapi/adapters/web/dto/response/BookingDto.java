package com.rhitmo.rhitmohospedeapi.adapters.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Booking}
 */
@Getter
@Setter
@Data
@AllArgsConstructor
public class BookingDto implements Serializable {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("checkIn")
    private Instant checkIn;

    @JsonProperty("checkOut")
    private Instant checkOut;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("status")
    private String status;

    @JsonProperty("roomId")
    private Integer roomId;

    @JsonProperty("userId")
    private Integer userId;
}
package com.rhitmo.rhitmohospedeapi.core.ports.output;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;

import java.time.Instant;


public interface IBookingOutputRepositoryPort {

    public CreatePostHttpResponseDto createBooking(BookingDomainModel booking);

    Boolean getBookingByRoomAndBookingDate(Integer roomId, Instant checkIn, Instant checkOut);
}

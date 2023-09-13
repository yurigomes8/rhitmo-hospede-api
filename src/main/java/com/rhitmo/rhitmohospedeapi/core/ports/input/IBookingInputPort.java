package com.rhitmo.rhitmohospedeapi.core.ports.input;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateBookingPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;

import java.time.Instant;
import java.util.List;


public interface IBookingInputPort {

    public CreatePostHttpResponseDto createBooking(CreateBookingPostHttpRequestDto request);

    List<ListAvailableRoomsGetHttpResponseDto> getAllAvailableRooms(Instant checkIn, Instant checkOut);
}

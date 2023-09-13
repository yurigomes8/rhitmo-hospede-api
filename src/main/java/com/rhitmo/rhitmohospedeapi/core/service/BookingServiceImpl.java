package com.rhitmo.rhitmohospedeapi.core.service;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateBookingPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.domain.enumeration.BookingStatus;
import com.rhitmo.rhitmohospedeapi.core.domain.exception.BusinessException;
import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;


import java.math.BigDecimal;
import java.time.*;
import java.util.List;

public class BookingServiceImpl implements IBookingInputPort {

    private final IBookingOutputRepositoryPort bookingOutputRepositoryPort;

    private final IUserOutputRepositoryPort userOutputRepositoryPort;

    private final IRoomOutputRepositoryPort roomOutputRepositoryPort;

    public BookingServiceImpl(IBookingOutputRepositoryPort bookingOutputRepositoryPort, IUserOutputRepositoryPort userOutputRepositoryPort, IRoomOutputRepositoryPort roomOutputRepositoryPort) {
        this.bookingOutputRepositoryPort = bookingOutputRepositoryPort;
        this.userOutputRepositoryPort = userOutputRepositoryPort;
        this.roomOutputRepositoryPort = roomOutputRepositoryPort;
    }


    @Override
    public CreatePostHttpResponseDto createBooking(CreateBookingPostHttpRequestDto request) {
        var room = roomOutputRepositoryPort.getRoomById(request.getRoomId());
        var totalAmount = calculatesBookingTotalPrice(room.getAmount(), request.getCheckIn(),request.getCheckOut());
        validatesBookingRoomAvailableForDate(room.getId(),request.getCheckIn(),request.getCheckOut());
        var booking = buildBooking(request,totalAmount);
        bookingOutputRepositoryPort.createBooking(booking);



        return null;
    }

    @Override
    public List<ListAvailableRoomsGetHttpResponseDto> getAllAvailableRooms(Instant checkIn, Instant checkOut) {

        return null;
    }

    private BookingDomainModel buildBooking(CreateBookingPostHttpRequestDto request, BigDecimal totalAmount){
        BookingDomainModel booking = new BookingDomainModel();
        booking.setCheckIn(request.getCheckIn());
        booking.setCheckOut(request.getCheckOut());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setRoomId(request.getRoomId());
        booking.setUserId(request.getUserId());
        booking.setTotalAmount(totalAmount);
        return booking;
    }


    private void validatesBookingRoomAvailableForDate(Integer idRoom, Instant checkIn, Instant checkOut){
        var bookingUnavailable = bookingOutputRepositoryPort.getBookingByRoomAndBookingDate(idRoom, checkIn, checkOut);
        if(bookingUnavailable){
            throw new BusinessException("Room not available for this date");
        }
    }


    private BigDecimal calculatesBookingTotalPrice(BigDecimal dailyPrice, Instant checkIn, Instant checkOut)
    {
        var days = Period.between(LocalDate.ofInstant(checkIn, ZoneOffset.UTC),LocalDate.ofInstant(checkOut, ZoneOffset.UTC) ).getDays();
        return dailyPrice.multiply(BigDecimal.valueOf(days));
    }







}

package com.rhitmo.rhitmohospedeapi.core.service;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import com.rhitmo.rhitmohospedeapi.core.domain.enumeration.BookingStatus;
import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.Period;

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
    public CreateBookingPostHttpResponse createBooking(CreateBookingPostHttpRequest request) {
        var room = roomOutputRepositoryPort.getRoomById(request.getRoomId());
        var totalAmount = calculatesBookingTotalPrice(room.getAmount(), request.getCheckIn(), request.getCheckOut());
        validatesBookingRoomAvailableForDate(room.getId(), request.getCheckIn(), request.getCheckOut());
        var booking = buildBooking(request,totalAmount);
        bookingOutputRepositoryPort.createBooking(booking);



        return null;
    }

    private BookingDomainModel buildBooking(CreateBookingPostHttpRequest request, BigDecimal totalAmount){
        BookingDomainModel booking = new BookingDomainModel();
        booking.setCheckIn(request.getCheckIn());
        booking.setCheckOut(request.getCheckOut());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setRoomId(request.getRoomId());
        booking.setUserId(request.getUserId());
        booking.setTotalAmount(totalAmount);
        return booking;
    }


    private void validatesBookingRoomAvailableForDate(Integer idRoom, OffsetDateTime checkIn, OffsetDateTime checkOut){

    }


    private BigDecimal calculatesBookingTotalPrice(BigDecimal dailyPrice, OffsetDateTime checkIn, OffsetDateTime checkOut)
    {
        var days = Period.between(checkIn.toLocalDate(), checkOut.toLocalDate()).getDays();
        var totalAmount = dailyPrice.multiply(BigDecimal.valueOf(days));
       return totalAmount;
    }







}

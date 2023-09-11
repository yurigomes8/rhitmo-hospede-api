package com.rhitmo.rhitmohospedeapi.core.usecase;

import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;

public class BookingUseCase implements IBookingInputPort {

    private final IBookingOutputRepositoryPort bookingOutputRepositoryPort;

    public BookingUseCase(IBookingOutputRepositoryPort bookingOutputRepositoryPort) {
        this.bookingOutputRepositoryPort = bookingOutputRepositoryPort;
    }


    @Override
    public CreateBookingPostHttpResponse createBooking(CreateBookingPostHttpRequest request) {
        return null;
    }


}

package com.rhitmo.rhitmohospedeapi.core.ports.output;

import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;

public interface IBookingOutputRepositoryPort {

    public CreateBookingPostHttpResponse createBooking(BookingDomainModel booking);
}

package com.rhitmo.rhitmohospedeapi.core.ports.input;

import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;
import org.springframework.stereotype.Component;



public interface IBookingInputPort {

    public CreateBookingPostHttpResponse createBooking(CreateBookingPostHttpRequest request);
}

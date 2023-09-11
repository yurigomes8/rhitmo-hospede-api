package com.rhitmo.rhitmohospedeapi.adapters.web.rest.v1;

import com.rhitmo.rhitmohospedeapi.api.RhitmoHospedeApi;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IRoomInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import com.rhitmo.rhitmohospedeapi.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class RhitmoHospedeController implements RhitmoHospedeApi {

    private final IBookingInputPort bookingInputPort;

    private final IUserInputPort userInputPort;

    private final IRoomInputPort roomInputPort;


    public RhitmoHospedeController(IBookingInputPort bookingInputPort, IUserInputPort userInputPort, IRoomInputPort roomInputPort) {
        this.bookingInputPort = bookingInputPort;
        this.userInputPort = userInputPort;
        this.roomInputPort = roomInputPort;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return RhitmoHospedeApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> cancelBooking(Integer bookingId) {
        return RhitmoHospedeApi.super.cancelBooking(bookingId);
    }

    @Override
    public ResponseEntity<CreateBookingPostHttpResponse> createBooking(CreateBookingPostHttpRequest createBookingPostHttpRequest) {
        var response = bookingInputPort.createBooking(createBookingPostHttpRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateRoomPostHttpResponse> createRoom(CreateRoomPostHttpRequest createRoomPostHttpRequest) {
        var response = roomInputPort.createRoom(createRoomPostHttpRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateUserPostHttpResponse> createUser(CreateUserPostHttpRequest createUserPostHttpRequest) {
       var response = userInputPort.createUser(createUserPostHttpRequest);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ListAvailableRoomsGetHttpResponse>> getAllAvailableRooms(OffsetDateTime checkIn, OffsetDateTime checkOut) {
        return RhitmoHospedeApi.super.getAllAvailableRooms(checkIn, checkOut);
    }

    @Override
    public ResponseEntity<ObtainRoomBookingsGetHttpResponse> getRoomBookings(Integer roomId) {
        return RhitmoHospedeApi.super.getRoomBookings(roomId);
    }

    @Override
    public ResponseEntity<Void> updateBooking(Integer bookingId) {
        return RhitmoHospedeApi.super.updateBooking(bookingId);
    }
}

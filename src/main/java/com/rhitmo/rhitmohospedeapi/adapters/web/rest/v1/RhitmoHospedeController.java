package com.rhitmo.rhitmohospedeapi.adapters.web.rest.v1;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateBookingPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateRoomPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateUserPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IRoomInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;


@Controller
@RestController
public class RhitmoHospedeController{

    private final IBookingInputPort bookingInputPort;

    private final IUserInputPort userInputPort;

    private final IRoomInputPort roomInputPort;


    public RhitmoHospedeController(IBookingInputPort bookingInputPort, IUserInputPort userInputPort, IRoomInputPort roomInputPort) {
        this.bookingInputPort = bookingInputPort;
        this.userInputPort = userInputPort;
        this.roomInputPort = roomInputPort;
    }

    @PostMapping(path = "/rhitmo-hospede/v1/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreatePostHttpResponseDto> createUser(@Valid @RequestBody CreateUserPostHttpRequestDto request) {
        var response = userInputPort.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/rhitmo-hospede/v1/room")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreatePostHttpResponseDto> createRoom(@Valid @RequestBody CreateRoomPostHttpRequestDto request) {
        var response = roomInputPort.createRoom(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/rhitmo-hospede/v1/booking")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreatePostHttpResponseDto> createBooking(@Valid @RequestBody CreateBookingPostHttpRequestDto request) {
        var response = bookingInputPort.createBooking(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    @GetMapping(path = "/rhitmo-hospede/v1/room/{roomId}/bookings")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ObtainRoomBookingsGetHttpResponseDto> getRoomBookings(@PathVariable @NotNull Integer roomId) {
//        var response = bookingInputPort.getRoomBookings(roomId);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
    @GetMapping(path = "/rhitmo-hospede/v1/rooms")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ListAvailableRoomsGetHttpResponseDto>> getAllAvailableRooms() {
        var response = roomInputPort.getAllAvailableRooms();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    @PatchMapping(path = "/rhitmo-hospede/v1/booking/{bookingId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> updateBooking(@PathVariable @NotNull Integer bookingId) {
//        bookingInputPort.updateBooking(bookingId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PatchMapping(path = "/rhitmo-hospede/v1/booking/{bookingId}/cancel")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> cancelBooking(@PathVariable @NotNull Integer bookingId) {
//        bookingInputPort.cancelBooking(bookingId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}

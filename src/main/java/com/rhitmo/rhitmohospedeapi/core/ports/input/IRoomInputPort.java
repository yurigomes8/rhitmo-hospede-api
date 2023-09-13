package com.rhitmo.rhitmohospedeapi.core.ports.input;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateRoomPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;

import java.util.List;


public interface IRoomInputPort {

    public CreatePostHttpResponseDto createRoom(CreateRoomPostHttpRequestDto request);

    List<ListAvailableRoomsGetHttpResponseDto> getAllAvailableRooms();

}

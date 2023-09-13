package com.rhitmo.rhitmohospedeapi.core.service;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateRoomPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IRoomInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;

import java.util.List;


public class RoomServiceImpl implements IRoomInputPort{

    private final IRoomOutputRepositoryPort roomOutputRepositoryPort;


    public RoomServiceImpl(IRoomOutputRepositoryPort roomOutputRepositoryPort) {
        this.roomOutputRepositoryPort = roomOutputRepositoryPort;
    }

    @Override
    public CreatePostHttpResponseDto createRoom(CreateRoomPostHttpRequestDto request) {
        return roomOutputRepositoryPort.createRoom(request);
    }

    @Override
    public List<ListAvailableRoomsGetHttpResponseDto> getAllAvailableRooms() {
        return roomOutputRepositoryPort.getAllAvailableRooms();
    }
}

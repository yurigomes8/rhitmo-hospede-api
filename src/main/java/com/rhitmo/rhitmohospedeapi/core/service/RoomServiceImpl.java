package com.rhitmo.rhitmohospedeapi.core.service;

import com.rhitmo.rhitmohospedeapi.core.ports.input.IRoomInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpResponse;

public class RoomServiceImpl implements IRoomInputPort{

    private final IRoomOutputRepositoryPort roomOutputRepositoryPort;


    public RoomServiceImpl(IRoomOutputRepositoryPort roomOutputRepositoryPort) {
        this.roomOutputRepositoryPort = roomOutputRepositoryPort;
    }

    @Override
    public CreateRoomPostHttpResponse createRoom(CreateRoomPostHttpRequest request) {
        return roomOutputRepositoryPort.createRoom(request);
    }
}

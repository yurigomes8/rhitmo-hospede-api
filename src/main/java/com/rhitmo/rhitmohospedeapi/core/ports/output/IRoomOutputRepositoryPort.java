package com.rhitmo.rhitmohospedeapi.core.ports.output;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpResponse;

public interface IRoomOutputRepositoryPort {

     CreateRoomPostHttpResponse createRoom(CreateRoomPostHttpRequest request);

     Room getRoomById(Integer id);

}

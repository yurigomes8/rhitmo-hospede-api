package com.rhitmo.rhitmohospedeapi.core.ports.input;

import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpResponse;
import org.springframework.stereotype.Component;


public interface IRoomInputPort {

    public CreateRoomPostHttpResponse createRoom(CreateRoomPostHttpRequest request);

}

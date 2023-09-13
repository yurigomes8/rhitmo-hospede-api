package com.rhitmo.rhitmohospedeapi.core.ports.output;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateRoomPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;

import java.util.List;

public interface IRoomOutputRepositoryPort {

     CreatePostHttpResponseDto createRoom(CreateRoomPostHttpRequestDto request);

     List<ListAvailableRoomsGetHttpResponseDto> getAllAvailableRooms();

     Room getRoomById(Integer id);

}

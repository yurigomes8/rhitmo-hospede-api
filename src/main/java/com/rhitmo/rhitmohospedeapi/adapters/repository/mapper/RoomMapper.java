package com.rhitmo.rhitmohospedeapi.adapters.repository.mapper;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateRoomPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {

    Room toEntity(CreateRoomPostHttpRequestDto createRoomPostHttpRequestDto);

    List<ListAvailableRoomsGetHttpResponseDto> toDtoList(List<Room> roomList);

    CreateRoomPostHttpRequestDto toDto1(Room room);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Room partialUpdate(CreateRoomPostHttpRequestDto createRoomPostHttpRequestDto, @MappingTarget Room room);
}
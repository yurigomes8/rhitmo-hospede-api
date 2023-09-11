package com.rhitmo.rhitmohospedeapi.adapters.repository.mapper;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {
   @Mapping(source = "dailyAmount", target = "amount")
    Room toEntity(CreateRoomPostHttpRequest createRoomPostHttpRequest);

    CreateBookingPostHttpResponse toDto(Room room);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Room partialUpdate(CreateRoomPostHttpRequest createRoomPostHttpRequest, @MappingTarget Room room);
}
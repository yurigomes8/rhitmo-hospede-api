package com.rhitmo.rhitmohospedeapi.adapters.repository.mapper;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {
    Booking toEntity(CreateBookingPostHttpRequest createBookingPostHttpRequest);

    CreateBookingPostHttpResponse toDto(Booking booking);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking partialUpdate(CreateBookingPostHttpRequest createBookingPostHttpRequest, @MappingTarget Booking booking);
}
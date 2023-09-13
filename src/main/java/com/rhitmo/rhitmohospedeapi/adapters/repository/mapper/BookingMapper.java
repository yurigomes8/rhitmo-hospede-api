package com.rhitmo.rhitmohospedeapi.adapters.repository.mapper;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateBookingPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    Booking toEntity(BookingDomainModel bookingDomainModel);


    CreateBookingPostHttpRequestDto toDto(Booking booking);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking partialUpdate(CreateBookingPostHttpRequestDto createBookingPostHttpRequestDto, @MappingTarget Booking booking);

}
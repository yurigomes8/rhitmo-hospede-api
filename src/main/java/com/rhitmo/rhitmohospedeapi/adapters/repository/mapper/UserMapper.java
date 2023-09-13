package com.rhitmo.rhitmohospedeapi.adapters.repository.mapper;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateUserPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.User;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(CreateUserPostHttpRequestDto createUserPostHttpRequestDto);

    CreateUserPostHttpRequestDto toDto1(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(CreateUserPostHttpRequestDto createUserPostHttpRequestDto, @MappingTarget User user);
}
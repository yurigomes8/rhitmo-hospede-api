package com.rhitmo.rhitmohospedeapi.core.ports.output;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateUserPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;


public interface IUserOutputRepositoryPort {
    public CreatePostHttpResponseDto createUser(CreateUserPostHttpRequestDto request);
}

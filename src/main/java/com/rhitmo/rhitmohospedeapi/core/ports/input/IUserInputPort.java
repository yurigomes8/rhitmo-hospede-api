package com.rhitmo.rhitmohospedeapi.core.ports.input;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateUserPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;



public interface IUserInputPort {

    public CreatePostHttpResponseDto createUser(CreateUserPostHttpRequestDto request);
}

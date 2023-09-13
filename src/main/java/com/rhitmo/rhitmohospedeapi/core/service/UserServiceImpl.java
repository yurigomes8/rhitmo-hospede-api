package com.rhitmo.rhitmohospedeapi.core.service;

import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateUserPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;


public class UserServiceImpl implements IUserInputPort {

    private final IUserOutputRepositoryPort userOutputRepositoryPort;

    public UserServiceImpl(IUserOutputRepositoryPort userOutputRepositoryPort) {
        this.userOutputRepositoryPort = userOutputRepositoryPort;
    }

    @Override
    public CreatePostHttpResponseDto createUser(CreateUserPostHttpRequestDto request) {
            return userOutputRepositoryPort.createUser(request);
    }
}

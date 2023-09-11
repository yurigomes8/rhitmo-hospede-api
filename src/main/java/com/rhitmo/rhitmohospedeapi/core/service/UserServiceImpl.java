package com.rhitmo.rhitmohospedeapi.core.service;

import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpResponse;

public class UserServiceImpl implements IUserInputPort {

    private final IUserOutputRepositoryPort userOutputRepositoryPort;

    public UserServiceImpl(IUserOutputRepositoryPort userOutputRepositoryPort) {
        this.userOutputRepositoryPort = userOutputRepositoryPort;
    }

    @Override
    public CreateUserPostHttpResponse createUser(CreateUserPostHttpRequest request) {
            return userOutputRepositoryPort.createUser(request);
    }
}

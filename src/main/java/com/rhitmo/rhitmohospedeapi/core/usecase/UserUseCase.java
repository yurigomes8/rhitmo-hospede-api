package com.rhitmo.rhitmohospedeapi.core.usecase;

import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpResponse;
import com.rhitmo.rhitmohospedeapi.model.Error;

public class UserUseCase implements IUserInputPort {

    private final IUserOutputRepositoryPort userOutputRepositoryPort;

    public UserUseCase(IUserOutputRepositoryPort userOutputRepositoryPort) {
        this.userOutputRepositoryPort = userOutputRepositoryPort;
    }

    @Override
    public CreateUserPostHttpResponse createUser(CreateUserPostHttpRequest request) {
            return userOutputRepositoryPort.createUser(request);
    }
}

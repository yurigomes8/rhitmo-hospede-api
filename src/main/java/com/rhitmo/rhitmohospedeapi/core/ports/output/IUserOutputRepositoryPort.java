package com.rhitmo.rhitmohospedeapi.core.ports.output;

import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpResponse;

public interface IUserOutputRepositoryPort {
    public CreateUserPostHttpResponse createUser(CreateUserPostHttpRequest request);
}

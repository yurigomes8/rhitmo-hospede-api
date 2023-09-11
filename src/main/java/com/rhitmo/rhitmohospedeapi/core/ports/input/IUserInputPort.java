package com.rhitmo.rhitmohospedeapi.core.ports.input;

import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpResponse;
import org.springframework.stereotype.Component;


public interface IUserInputPort {

    public CreateUserPostHttpResponse createUser(CreateUserPostHttpRequest request);
}

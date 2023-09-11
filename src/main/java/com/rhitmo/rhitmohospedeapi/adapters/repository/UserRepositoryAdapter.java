package com.rhitmo.rhitmohospedeapi.adapters.repository;

import com.rhitmo.rhitmohospedeapi.adapters.repository.jpa.UserRepository;
import com.rhitmo.rhitmohospedeapi.adapters.repository.mapper.UserMapper;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateUserPostHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class UserRepositoryAdapter implements IUserOutputRepositoryPort {


    private final UserRepository userRepository;


    private final UserMapper userMapper;

    public UserRepositoryAdapter(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public CreateUserPostHttpResponse createUser(CreateUserPostHttpRequest request) {
        try{
            var userSaved = userRepository.save(userMapper.toEntity(request));
            return new CreateUserPostHttpResponse()
                    .id(userSaved.getId())
                    .dataCriacao(OffsetDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

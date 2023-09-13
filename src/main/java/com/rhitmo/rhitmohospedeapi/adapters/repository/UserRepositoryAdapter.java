package com.rhitmo.rhitmohospedeapi.adapters.repository;

import com.rhitmo.rhitmohospedeapi.adapters.repository.jpa.UserRepository;
import com.rhitmo.rhitmohospedeapi.adapters.repository.mapper.UserMapper;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateUserPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.Instant;
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
    public CreatePostHttpResponseDto createUser(CreateUserPostHttpRequestDto request) {
        try{
            var userSaved = userRepository.save(userMapper.toEntity(request));
            return new CreatePostHttpResponseDto().builder()
                    .id(userSaved.getId())
                    .createdAt(Instant.now())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

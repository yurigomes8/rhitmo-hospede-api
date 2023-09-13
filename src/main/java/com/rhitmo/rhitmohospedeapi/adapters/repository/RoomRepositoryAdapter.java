package com.rhitmo.rhitmohospedeapi.adapters.repository;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import com.rhitmo.rhitmohospedeapi.adapters.repository.jpa.RoomRepository;
import com.rhitmo.rhitmohospedeapi.adapters.repository.mapper.RoomMapper;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.request.CreateRoomPostHttpRequestDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.ListAvailableRoomsGetHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.domain.exception.BusinessException;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

import java.util.List;

@Component
public class RoomRepositoryAdapter implements IRoomOutputRepositoryPort {
    @Autowired
    private final RoomRepository roomRepository;


    @Autowired
    private final RoomMapper roomMapper;

    public RoomRepositoryAdapter(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }


    @Override
    public CreatePostHttpResponseDto createRoom(CreateRoomPostHttpRequestDto request) {
        try{
            var roomSaved = roomRepository.save(roomMapper.toEntity(request));
            return new CreatePostHttpResponseDto(roomSaved.getId(), Instant.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ListAvailableRoomsGetHttpResponseDto> getAllAvailableRooms() {
        try{
            var rooms = roomRepository.findAll();
            return roomMapper.toDtoList(rooms);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Room getRoomById(Integer id) {
        if(roomRepository.findById(id).isPresent()) {
            return roomRepository.findById(id).get();
        } else {
            throw new BusinessException("RHBOOKREPOADPROOM-58","Room not found");
        }
    }
}

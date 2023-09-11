package com.rhitmo.rhitmohospedeapi.adapters.repository;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import com.rhitmo.rhitmohospedeapi.adapters.repository.jpa.RoomRepository;
import com.rhitmo.rhitmohospedeapi.adapters.repository.mapper.RoomMapper;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateRoomPostHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

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
    public CreateRoomPostHttpResponse createRoom(CreateRoomPostHttpRequest request) {
        try{
            var roomSaved = roomRepository.save(roomMapper.toEntity(request));
            return new CreateRoomPostHttpResponse()
                    .id(roomSaved.getId())
                    .dataCriacao(OffsetDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Room getRoomById(Integer id) {
        if(roomRepository.findById(id).isPresent()) {
            return roomRepository.findById(id).get();
        } else {
            throw new RuntimeException("RoomDomainModel not found");
        }
    }
}

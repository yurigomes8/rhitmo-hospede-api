package com.rhitmo.rhitmohospedeapi.adapters.repository.jpa;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Override
    Optional<Room> findById(Integer integer);
}
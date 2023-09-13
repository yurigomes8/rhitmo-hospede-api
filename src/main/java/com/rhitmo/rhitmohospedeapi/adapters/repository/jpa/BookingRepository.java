package com.rhitmo.rhitmohospedeapi.adapters.repository.jpa;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Optional<Booking>> findByRoomId(Integer roomId);


}
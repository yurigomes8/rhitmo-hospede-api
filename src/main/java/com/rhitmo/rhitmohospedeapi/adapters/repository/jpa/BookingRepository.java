package com.rhitmo.rhitmohospedeapi.adapters.repository.jpa;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
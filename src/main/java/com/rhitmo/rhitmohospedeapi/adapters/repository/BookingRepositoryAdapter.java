package com.rhitmo.rhitmohospedeapi.adapters.repository;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Booking;
import com.rhitmo.rhitmohospedeapi.adapters.repository.jpa.BookingRepository;
import com.rhitmo.rhitmohospedeapi.adapters.repository.mapper.BookingMapper;
import com.rhitmo.rhitmohospedeapi.adapters.web.dto.response.CreatePostHttpResponseDto;
import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;

@Component
public class BookingRepositoryAdapter implements IBookingOutputRepositoryPort {


    @Autowired
    private final BookingRepository bookingRepository;



    @Autowired
    private final BookingMapper bookingMapper;

    public BookingRepositoryAdapter(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public CreatePostHttpResponseDto createBooking(BookingDomainModel booking) {
        try{
            var bookingSaved = bookingRepository.save(bookingMapper.toEntity(booking));
            return new CreatePostHttpResponseDto()
                    .builder()
                    .id(bookingSaved.getId())
                    .createdAt(Instant.now()).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean getBookingByRoomAndBookingDate(Integer roomId, Instant checkIn, Instant checkOut) {
        try{
            var bookings = bookingRepository.findByRoomId(roomId);
            var unavailable = bookings.stream().filter(
                    booking -> booking.get().getCheckIn().equals(checkIn) || booking.get().getCheckOut().equals(checkOut)
            ).findFirst();
            return unavailable.isPresent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

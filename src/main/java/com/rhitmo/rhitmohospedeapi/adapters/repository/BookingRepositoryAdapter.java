package com.rhitmo.rhitmohospedeapi.adapters.repository;

import com.rhitmo.rhitmohospedeapi.adapters.repository.jpa.BookingRepository;
import com.rhitmo.rhitmohospedeapi.adapters.repository.mapper.BookingMapper;
import com.rhitmo.rhitmohospedeapi.core.domain.models.BookingDomainModel;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpRequest;
import com.rhitmo.rhitmohospedeapi.model.CreateBookingPostHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class BookingRepositoryAdapter implements IBookingOutputRepositoryPort {


    private final BookingRepository bookingRepository;



    private final BookingMapper bookingMapper;

    public BookingRepositoryAdapter(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public CreateBookingPostHttpResponse createBooking(BookingDomainModel booking) {
        try{
            var bookingSaved = bookingRepository.save(bookingMapper.toEntity(booking));
            return new CreateBookingPostHttpResponse()
                    .id(bookingSaved.getId())
                    .dataCriacao(OffsetDateTime.now().toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

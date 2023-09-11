package com.rhitmo.rhitmohospedeapi.config;

import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IRoomInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.service.BookingServiceImpl;
import com.rhitmo.rhitmohospedeapi.core.service.RoomServiceImpl;
import com.rhitmo.rhitmohospedeapi.core.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    IBookingInputPort bookingUseCase(IBookingOutputRepositoryPort bookingOutputRepositoryPort, IUserOutputRepositoryPort userOutputRepositoryPort, IRoomOutputRepositoryPort roomOutputRepositoryPort){
        return new BookingServiceImpl(bookingOutputRepositoryPort, userOutputRepositoryPort, roomOutputRepositoryPort);
    }

    @Bean
    IUserInputPort userUseCase(IUserOutputRepositoryPort userOutputRepositoryPort){
        return new UserServiceImpl(userOutputRepositoryPort);
    }

    @Bean
    IRoomInputPort roomUseCase(IRoomOutputRepositoryPort roomOutputRepositoryPort){
        return new RoomServiceImpl(roomOutputRepositoryPort);
    }

}

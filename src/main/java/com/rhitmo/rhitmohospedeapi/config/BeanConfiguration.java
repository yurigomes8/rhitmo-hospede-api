package com.rhitmo.rhitmohospedeapi.config;

import com.rhitmo.rhitmohospedeapi.core.ports.input.IBookingInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IRoomInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.input.IUserInputPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IBookingOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IRoomOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.ports.output.IUserOutputRepositoryPort;
import com.rhitmo.rhitmohospedeapi.core.usecase.BookingUseCase;
import com.rhitmo.rhitmohospedeapi.core.usecase.RoomUseCase;
import com.rhitmo.rhitmohospedeapi.core.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    IBookingInputPort bookingUseCase(IBookingOutputRepositoryPort bookingOutputRepositoryPort){
        return new BookingUseCase(bookingOutputRepositoryPort);
    }

    @Bean
    IUserInputPort userUseCase(IUserOutputRepositoryPort userOutputRepositoryPort){
        return new UserUseCase(userOutputRepositoryPort);
    }

    @Bean
    IRoomInputPort roomUseCase(IRoomOutputRepositoryPort roomOutputRepositoryPort){
        return new RoomUseCase(roomOutputRepositoryPort);
    }

}

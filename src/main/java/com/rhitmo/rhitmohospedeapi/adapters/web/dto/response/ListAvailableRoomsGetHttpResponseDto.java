package com.rhitmo.rhitmohospedeapi.adapters.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.Room;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@ToString
@NoArgsConstructor
@Data
public class ListAvailableRoomsGetHttpResponseDto {

    @JsonProperty("rooms")
    private List<Room> rooms;
}

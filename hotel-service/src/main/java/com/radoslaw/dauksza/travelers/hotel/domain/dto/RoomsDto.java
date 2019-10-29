package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class RoomsDto {
    private Map<String, RoomDto> rooms = new HashMap<>();

    @JsonAnyGetter
    public Map<String, RoomDto> getRooms() {
        return rooms;
    }

    @JsonAnySetter
    public void setRooms(String key, RoomDto roomDto) {
        rooms.put(key, roomDto);
    }
}

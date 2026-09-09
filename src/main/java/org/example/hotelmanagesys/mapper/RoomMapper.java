package org.example.hotelmanagesys.mapper;

import org.example.hotelmanagesys.Dto.RoomDTO;
import org.example.hotelmanagesys.entity.Hotel;
import org.example.hotelmanagesys.entity.Room;

public class RoomMapper {

    public static RoomDTO toDTO(Room room) {

        return RoomDTO.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .type(room.getType())
                .price(room.getPrice())
                .hotelId(room.getHotel().getId())
                .build();
    }

    public static Room toEntity(RoomDTO dto, Hotel hotel) {

        return Room.builder()
                .id(dto.getId())
                .roomNumber(dto.getRoomNumber())
                .type(dto.getType())
                .price(dto.getPrice())
                .hotel(hotel)
                .build();
    }
}
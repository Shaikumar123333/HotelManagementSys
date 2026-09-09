package org.example.hotelmanagesys.mapper;

import org.example.hotelmanagesys.Dto.HotelDTO;
import org.example.hotelmanagesys.entity.Hotel;

public class HotelMapper {

    public static HotelDTO toDTO(Hotel hotel) {

        return HotelDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .location(hotel.getLocation())
                .totalRooms(hotel.getTotalRooms())
                .build();
    }

    public static Hotel toEntity(HotelDTO dto) {

        return Hotel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .totalRooms(dto.getTotalRooms())
                .build();
    }
}
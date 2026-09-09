package org.example.hotelmanagesys.mapper;


import org.example.hotelmanagesys.Dto.BookingDTO;
import org.example.hotelmanagesys.entity.Booking;
import org.example.hotelmanagesys.entity.Room;
import org.example.hotelmanagesys.entity.User;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {

        return BookingDTO.builder()
                .id(booking.getId())
                .checkIn(booking.getCheckIn())
                .checkOut(booking.getCheckOut())
                .status(booking.getStatus())
                .userId(booking.getUser().getId())
                .roomId(booking.getRoom().getId())
                .build();
    }

    public static Booking toEntity(
            BookingDTO dto,
            User user,
            Room room
    ) {

        return Booking.builder()
                .id(dto.getId())
                .checkIn(dto.getCheckIn())
                .checkOut(dto.getCheckOut())
                .status(dto.getStatus())
                .user(user)
                .room(room)
                .build();
    }
}
package org.example.hotelmanagesys.mapper;


import org.example.hotelmanagesys.Dto.UserDTO;
import org.example.hotelmanagesys.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toEntity(UserDTO dto) {

        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }
}
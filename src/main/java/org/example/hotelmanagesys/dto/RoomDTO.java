package org.example.hotelmanagesys.Dto;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {

    private Long id;

    private String roomNumber;

    private String type;

    private Double price;

    private Long hotelId;
}

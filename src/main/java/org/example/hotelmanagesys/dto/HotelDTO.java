package org.example.hotelmanagesys.Dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {

    private Long id;

    private String name;

    private String location;

    private Integer totalRooms;
}

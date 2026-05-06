package org.example.hotelmanagesys.dto;
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

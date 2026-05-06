package org.example.hotelmanagesys.dto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {

    private Long id;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private String status;

    private Long userId;

    private Long roomId;
}

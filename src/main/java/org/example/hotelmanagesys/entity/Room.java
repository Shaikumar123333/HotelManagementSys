package org.example.hotelmanagesys.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.hotelmanagesys.entity.Booking;
import org.example.hotelmanagesys.entity.Hotel;

import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private String type;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
}
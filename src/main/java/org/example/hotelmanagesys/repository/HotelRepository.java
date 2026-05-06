package org.example.hotelmanagesys.repository;

import org.example.hotelmanagesys.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

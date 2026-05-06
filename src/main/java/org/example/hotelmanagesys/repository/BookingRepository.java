package org.example.hotelmanagesys.repository;

import org.example.hotelmanagesys.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

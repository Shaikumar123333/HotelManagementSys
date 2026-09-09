package org.example.hotelmanagesys.repository;

import org.example.hotelmanagesys.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
SELECT b FROM Booking b
WHERE b.room.id = :roomId
AND (
    :checkIn <= b.checkOut
    AND :checkOut >= b.checkIn
)
""")
    List<Booking> findConflictingBookings(
            @Param("roomId") Long roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut
    );
}

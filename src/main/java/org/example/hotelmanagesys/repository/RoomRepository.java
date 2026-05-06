package org.example.hotelmanagesys.repository;

import org.example.hotelmanagesys.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

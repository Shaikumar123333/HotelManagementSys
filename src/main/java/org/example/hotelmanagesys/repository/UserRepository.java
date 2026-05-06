package org.example.hotelmanagesys.repository;

import org.example.hotelmanagesys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

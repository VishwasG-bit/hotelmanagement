package com.example.hotelmanagement.Rooms;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room , Long> {

    List<Room> findByAvailable(boolean available);
}

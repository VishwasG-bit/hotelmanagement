package com.example.hotelmanagement.Rooms;


import com.example.hotelmanagement.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();

    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailable(true);
    }

    public Room bookRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() ->
                new ResourceNotFoundException("Room not found")
        );
        room.setAvailable(false);
        return roomRepository.save(room);
    }




}

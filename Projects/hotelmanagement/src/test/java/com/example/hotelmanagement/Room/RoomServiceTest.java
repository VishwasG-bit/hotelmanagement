package com.example.hotelmanagement.Room;


import com.example.hotelmanagement.Rooms.Room;
import com.example.hotelmanagement.Rooms.RoomRepository;
import com.example.hotelmanagement.Rooms.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    public void testGetAllRooms() {

        Room room1 = new Room();
        Room room2 = new Room();

        when(roomRepository.findAll()).thenReturn(Arrays.asList(room1, room2));

        List<Room> rooms = roomService.getAvailableRooms();
        assertEquals(2, rooms.size());
        verify(roomRepository, times(1)).findAll();
    }

    @Test
    public void testGetAvailableRooms() {

        Room room1 = new Room();
        Room room2 = new Room();

        when(roomRepository.findByAvailable(true)).thenReturn(Arrays.asList(room1, room2));

        List<Room> rooms = roomService.getAvailableRooms();
        assertEquals(2, rooms.size());
        verify(roomRepository, times(1)).findByAvailable(true);

    }

    @Test
    public void testBookRoom(){

        Room room = new Room();
        room.setId(1L);
        room.setAvailable(true);

        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));
        when(roomRepository.save(any(Room.class))).thenReturn(room);

        Room bookedRoom = roomService.bookRoom(1L);
        assertFalse(bookedRoom.isAvailable());
        verify(roomRepository, times(1)).findById(1L);
        verify(roomRepository, times(1)).save(room);

    }
}




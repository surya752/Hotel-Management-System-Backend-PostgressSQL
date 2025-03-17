package com.ReceptionistMicroservice.Receptionist.Service;

import com.ReceptionistMicroservice.Receptionist.Entity.Room;

import java.util.List;

public interface RoomService {
    Room saveRoom(Room room);
    List<Room> getAllRooms();
    Room getById(int id);
    Room updateRoom(Room room,int id);
    void deleteRoom(int id);
}

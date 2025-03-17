package com.ReceptionistMicroservice.Receptionist.ServiceImpl;

import com.ReceptionistMicroservice.Receptionist.Entity.Room;
import com.ReceptionistMicroservice.Receptionist.Exception.ResourceNotFoundException;
import com.ReceptionistMicroservice.Receptionist.Repository.RoomRepository;
import com.ReceptionistMicroservice.Receptionist.Service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        super();
        this.roomRepository = roomRepository;
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(int id) {
        return roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room","Id",id));
    }

    @Override
    public Room updateRoom(@Validated Room room, int id) {
        Room existRoom=roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room","Id",id));
        existRoom.setRoomNo(room.getRoomNo());
        existRoom.setRoomCost(room.getRoomCost());
        existRoom.setRoomType(room.getRoomType());
        existRoom.setCheckIn(room.getCheckIn());
        existRoom.setCheckOut(room.getCheckOut());
        existRoom.setIsOccupied(room.getIsOccupied());
        roomRepository.save(existRoom);
        return existRoom;
    }

    @Override
    public void deleteRoom(int id) {
        roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room","Id",id));
        roomRepository.deleteById(id);

    }
}

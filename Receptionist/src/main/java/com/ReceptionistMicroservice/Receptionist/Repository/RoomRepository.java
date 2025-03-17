package com.ReceptionistMicroservice.Receptionist.Repository;

import com.ReceptionistMicroservice.Receptionist.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}

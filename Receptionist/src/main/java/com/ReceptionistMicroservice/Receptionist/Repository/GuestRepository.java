package com.ReceptionistMicroservice.Receptionist.Repository;

import com.ReceptionistMicroservice.Receptionist.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Integer> {
}

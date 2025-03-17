package com.ReceptionistMicroservice.Receptionist.Repository;

import com.ReceptionistMicroservice.Receptionist.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}

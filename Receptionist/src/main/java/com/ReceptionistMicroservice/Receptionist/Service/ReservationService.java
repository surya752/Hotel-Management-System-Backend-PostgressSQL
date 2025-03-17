package com.ReceptionistMicroservice.Receptionist.Service;

import com.ReceptionistMicroservice.Receptionist.Entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getById(int id);
    Reservation updateReservation(Reservation reservation,int id);
    void deleteReservation(int id);
}

package com.ReceptionistMicroservice.Receptionist.ServiceImpl;

import com.ReceptionistMicroservice.Receptionist.Entity.Reservation;
import com.ReceptionistMicroservice.Receptionist.Exception.ResourceNotFoundException;
import com.ReceptionistMicroservice.Receptionist.Repository.ReservationRepository;
import com.ReceptionistMicroservice.Receptionist.Service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        super();
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(int id) {
        return reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reservation","Id",id));
    }

    @Override
    public Reservation updateReservation(@Validated Reservation reservation, int id) {
        Reservation existReservation=reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reservation","Id",id));
        existReservation.setRoomNo(reservation.getRoomNo());
        existReservation.setChildren(reservation.getChildren());
        existReservation.setAdults(reservation.getAdults());
        existReservation.setCheckindate(reservation.getCheckindate());
        existReservation.setCheckoutdate(reservation.getCheckoutdate());
        reservationRepository.save(existReservation);
        return existReservation;
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reservation","Id",id));
        reservationRepository.deleteById(id);
    }


}

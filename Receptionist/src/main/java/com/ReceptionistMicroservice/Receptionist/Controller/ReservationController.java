package com.ReceptionistMicroservice.Receptionist.Controller;

import com.ReceptionistMicroservice.Receptionist.Entity.Reservation;
import com.ReceptionistMicroservice.Receptionist.Service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        super();
        this.reservationService = reservationService;
    }
    @PostMapping("/reservation/save")
    public ResponseEntity<Reservation> saveReservation(@Valid @RequestBody Reservation reservation){
        return new ResponseEntity<Reservation>(reservationService.saveReservation(reservation), HttpStatus.CREATED);
    }
    @GetMapping("reservation/list")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }
    @GetMapping("reservation/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable("id") int id){
        return new ResponseEntity<Reservation>(reservationService.getById(id),HttpStatus.OK);
    }
    @PutMapping("reservation/edit/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation,@PathVariable("id") int id){
        return new ResponseEntity<Reservation>(reservationService.updateReservation(reservation,id),HttpStatus.OK);
    }
    @DeleteMapping("reservation/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") int id){
        reservationService.deleteReservation(id);
        return new ResponseEntity<String>("Reservation Deleted",HttpStatus.OK);
    }
}

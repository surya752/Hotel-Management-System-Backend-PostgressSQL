package com.ReceptionistMicroservice.Receptionist.Controller;

import com.ReceptionistMicroservice.Receptionist.Entity.Guest;
import com.ReceptionistMicroservice.Receptionist.Service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class GuestController {
    private GuestService guestService;

    public GuestController(GuestService guestService) {
        super();
        this.guestService = guestService;
    }

    @PostMapping("/guest/save")
    public ResponseEntity<Guest> saveGuest(@Valid @RequestBody Guest guest){
        return new ResponseEntity<Guest>(guestService.saveGuest(guest), HttpStatus.CREATED);
    }

    @GetMapping("/guest/list")
    public List<Guest> getAllGuests(){
        return guestService.getAllGuests();
    }
    @GetMapping("guest/{id}")
    public ResponseEntity<Guest> getById(@PathVariable("id") int id){
        return new ResponseEntity<Guest>(guestService.getById(id),HttpStatus.OK);
    }
    @PutMapping("guest/edit/{id}")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest,@PathVariable("id") int id){
        return new ResponseEntity<Guest>(guestService.updateGuest(guest,id),HttpStatus.OK);
    }
    @DeleteMapping("guest/delete/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable("id") int id){
        guestService.deleteGuest(id);
        return new ResponseEntity<String >("Guest Deleted",HttpStatus.OK);

    }
}

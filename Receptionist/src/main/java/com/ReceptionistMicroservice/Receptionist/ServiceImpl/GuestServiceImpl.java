package com.ReceptionistMicroservice.Receptionist.ServiceImpl;

import com.ReceptionistMicroservice.Receptionist.Entity.Guest;
import com.ReceptionistMicroservice.Receptionist.Exception.ResourceNotFoundException;
import com.ReceptionistMicroservice.Receptionist.Repository.GuestRepository;
import com.ReceptionistMicroservice.Receptionist.Service.GuestService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    private GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        super();
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getById(int id) {
        return guestRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Guest","Id",id));
    }

    @Override
    public Guest updateGuest(@Validated Guest guest, int id) {
        Guest existGuest = guestRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Guest","Id",id));
        existGuest.setName(guest.getName());
        existGuest.setEmail(guest.getEmail());
        existGuest.setPhoneNo(guest.getPhoneNo());
        existGuest.setRoomNo(guest.getRoomNo());
        existGuest.setGender(guest.getGender());
        existGuest.setAddress(guest.getAddress());
        guestRepository.save(existGuest);
        return existGuest ;
    }

    @Override
    public void deleteGuest(int id) {
        guestRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Guest","Id",id));
        guestRepository.deleteById(id);



    }
}

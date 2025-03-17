package com.ReceptionistMicroservice.Receptionist.Service;

import com.ReceptionistMicroservice.Receptionist.Entity.Guest;

import java.util.List;

public interface GuestService {
     Guest saveGuest(Guest guest);
     List<Guest> getAllGuests();
     Guest getById(int id);
     Guest updateGuest(Guest guest, int id);
     void deleteGuest(int id);


}

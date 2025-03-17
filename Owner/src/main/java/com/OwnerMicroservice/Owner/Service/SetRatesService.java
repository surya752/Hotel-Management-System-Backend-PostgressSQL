package com.OwnerMicroservice.Owner.Service;

import com.OwnerMicroservice.Owner.Entity.SetRates;


import java.util.List;

public interface SetRatesService {
    SetRates saveSetRates(SetRates setRates);
    List<SetRates> getAllSetRates();
    SetRates getById(int id);
    SetRates updateSetRates(SetRates setRates,int id);
    void deleteSetRates(int id);


}

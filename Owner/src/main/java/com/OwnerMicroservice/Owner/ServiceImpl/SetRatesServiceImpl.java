package com.OwnerMicroservice.Owner.ServiceImpl;

import com.OwnerMicroservice.Owner.Entity.SetRates;
import com.OwnerMicroservice.Owner.Exception.ResourceNotFoundException;
import com.OwnerMicroservice.Owner.Repository.SetRatesRepository;
import com.OwnerMicroservice.Owner.Service.SetRatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetRatesServiceImpl implements SetRatesService {
    private SetRatesRepository setRatesRepository;

    public SetRatesServiceImpl(SetRatesRepository setRatesRepository) {
        super();
        this.setRatesRepository = setRatesRepository;
    }

    @Override
    public SetRates saveSetRates(SetRates setRates) {
        return setRatesRepository.save(setRates);
    }

    @Override
    public List<SetRates> getAllSetRates() {
        return setRatesRepository.findAll();
    }

    @Override
    public SetRates getById(int id) {
        return setRatesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("SetRates","Id",id));
    }

    @Override
    public SetRates updateSetRates(SetRates setRates, int id) {
        SetRates existSetRates = setRatesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("SetRates","Id",id));
        existSetRates.setGuest(setRates.getGuest());
        existSetRates.setDays(setRates.getDays());
        existSetRates.setExtension(setRates.getExtension());
        existSetRates.setNightPrice(setRates.getNightPrice());
        setRatesRepository.save(existSetRates);
        return existSetRates;
    }

    @Override
    public void deleteSetRates(int id) {
        setRatesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("SetRates","Id",id));
        setRatesRepository.deleteById(id);
    }
}

package com.ReceptionistMicroservice.Receptionist.ServiceImpl;

import com.ReceptionistMicroservice.Receptionist.Entity.IssueBills;
import com.ReceptionistMicroservice.Receptionist.Exception.ResourceNotFoundException;
import com.ReceptionistMicroservice.Receptionist.Repository.IssueBillsRepository;
import com.ReceptionistMicroservice.Receptionist.Service.IssueBillsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class IssueBillsServiceImpl implements IssueBillsService {

    private IssueBillsRepository issueBillsRepository;

    public IssueBillsServiceImpl(IssueBillsRepository issueBillsRepository) {
        this.issueBillsRepository = issueBillsRepository;
    }

    @Override
    public IssueBills saveIssueBill(IssueBills issueBills) {
        return issueBillsRepository.save(issueBills) ;
    }

    @Override
    public List<IssueBills> getAllIssueBills() {
        return issueBillsRepository.findAll();
    }

    @Override
    public IssueBills getByBillNo(int billNo) {
        return issueBillsRepository.findById(billNo).orElseThrow(()-> new ResourceNotFoundException("IssueBill","BillNO",billNo));
    }

    @Override
    public IssueBills updateIssueBill(@Validated IssueBills issueBills, int billNo) {
        IssueBills existIssueBills=issueBillsRepository.findById(billNo).orElseThrow(()->new ResourceNotFoundException("IssueBill","BillNo",billNo));
        existIssueBills.setRoomNo(issueBills.getRoomNo());
        existIssueBills.setService(issueBills.getService());
        existIssueBills.setPrice(issueBills.getPrice());
        existIssueBills.setTaxes(issueBills.getTaxes());
        existIssueBills.setDate(issueBills.getDate());
        existIssueBills.setTotal(issueBills.getTotal());
        issueBillsRepository.save(existIssueBills);
        return existIssueBills;
    }

    @Override
    public void deleteIssueBill(int billNo) {
        issueBillsRepository.findById(billNo).orElseThrow(() -> new ResourceNotFoundException("Issuebill", "BillNo", billNo));
        issueBillsRepository.deleteById(billNo);
    }


}

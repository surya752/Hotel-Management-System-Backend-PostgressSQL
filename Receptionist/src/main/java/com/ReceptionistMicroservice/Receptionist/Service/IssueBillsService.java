package com.ReceptionistMicroservice.Receptionist.Service;

import com.ReceptionistMicroservice.Receptionist.Entity.IssueBills;
import java.util.List;


public interface IssueBillsService {
    IssueBills saveIssueBill(IssueBills issueBills);
    List<IssueBills> getAllIssueBills();
    IssueBills getByBillNo(int billNo);
    IssueBills updateIssueBill(IssueBills issueBills,int billNo);
    void deleteIssueBill(int billNo);

}

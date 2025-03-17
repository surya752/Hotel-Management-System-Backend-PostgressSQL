package com.ReceptionistMicroservice.Receptionist.Service;

import com.ReceptionistMicroservice.Receptionist.Entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllpayments();
    Payment getById(int id);
    Payment updatePayment(Payment payment,int id);
    void deletePayment(int id);

}

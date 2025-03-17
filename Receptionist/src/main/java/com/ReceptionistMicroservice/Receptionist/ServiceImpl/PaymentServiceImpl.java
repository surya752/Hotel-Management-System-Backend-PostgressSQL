package com.ReceptionistMicroservice.Receptionist.ServiceImpl;

import com.ReceptionistMicroservice.Receptionist.Entity.Payment;
import com.ReceptionistMicroservice.Receptionist.Exception.ResourceNotFoundException;
import com.ReceptionistMicroservice.Receptionist.Repository.PaymentRepository;
import com.ReceptionistMicroservice.Receptionist.Service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        super();
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllpayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(int id) {
        return paymentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Payment","Id",id));
    }

    @Override
    public Payment updatePayment(@Validated Payment payment, int id) {
        Payment existPayment= paymentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment","Id",id));
        existPayment.setRoomNo(payment.getRoomNo());
        existPayment.setCreditcard(payment.getCreditcard());
        existPayment.setTotal(payment.getTotal());
        existPayment.setPaytime(payment.getPaytime());
        paymentRepository.save(existPayment);
        return existPayment;
    }

    @Override
    public void deletePayment(int id) {
        paymentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Payment","Id",id));
        paymentRepository.deleteById(id);

    }

}

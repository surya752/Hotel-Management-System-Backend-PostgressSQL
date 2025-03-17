package com.ReceptionistMicroservice.Receptionist.Repository;

import com.ReceptionistMicroservice.Receptionist.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}

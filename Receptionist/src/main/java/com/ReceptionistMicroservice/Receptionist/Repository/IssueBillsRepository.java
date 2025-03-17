package com.ReceptionistMicroservice.Receptionist.Repository;

import com.ReceptionistMicroservice.Receptionist.Entity.IssueBills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBillsRepository extends JpaRepository<IssueBills,Integer> {
}

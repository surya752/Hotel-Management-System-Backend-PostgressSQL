package com.ManagerMicroservice.Manager.Repository;

import com.ManagerMicroservice.Manager.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

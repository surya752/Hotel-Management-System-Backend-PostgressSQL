package com.ManagerMicroservice.Manager.Service;

import com.ManagerMicroservice.Manager.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(int id);
    Employee updateEmployee(Employee employee, int id);
    void deleteEmployee(int id);

}

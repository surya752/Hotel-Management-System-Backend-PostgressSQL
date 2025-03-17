package com.ManagerMicroservice.Manager.ServiceImpl;

import com.ManagerMicroservice.Manager.Entity.Employee;
import com.ManagerMicroservice.Manager.Exception.ResourceNotFoundException;
import com.ManagerMicroservice.Manager.Repository.EmployeeRepository;
import com.ManagerMicroservice.Manager.Service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(@Validated Employee employee, int id) {
        Employee existEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setEmpAddress(employee.getEmpAddress());
        existEmployee.setEmpName(employee.getEmpName());
        existEmployee.setSalary(employee.getSalary());
        existEmployee.setOccupation(employee.getOccupation());
        employeeRepository.save(existEmployee);
        return existEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}

package com.ManagerMicroservice.Manager.Controller;

import com.ManagerMicroservice.Manager.Entity.Employee;
import com.ManagerMicroservice.Manager.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Manager")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    @PostMapping("/employee/save")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/employee/list")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id){
        return new ResponseEntity<Employee>(employeeService.getById(id),HttpStatus.OK);
    }
    @PutMapping("employee/edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("employee/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted",HttpStatus.OK);
    }
}

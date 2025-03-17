package com.ManagerMicroservice.Manager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, message = " Name should have atleast 2 characters")
    @Column(name = "EmployeeName")
    private String empName;
    @NotNull
    @Column(name = "EmployeeAddress")
    private String empAddress;
    @NotNull
    @Column(name = "Salary")
    private int salary;
    @NotNull
    @Size(min = 2, message = " Occuption should have atleast 2 characters")
    @Column(name = "Occupation")
    private String occupation;
    @Email
    @NotBlank
    @Column(name = "Email")
    private String email;

}
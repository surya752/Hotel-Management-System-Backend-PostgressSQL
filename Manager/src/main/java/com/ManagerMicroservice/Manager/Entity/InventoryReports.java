package com.ManagerMicroservice.Manager.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InventoryReports")
public class InventoryReports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "TotalIncome")
    private Long totalincome;
    @NotNull
    @Column(name = "MaintainanceCost")
    private Long maintainanceCost;
    @NotNull
    @Column(name = "EmployeeSalary")
    private Long employeesalary;
    @NotNull
    @Column(name = "TotalProfit")
    private Long totalProfit;
}
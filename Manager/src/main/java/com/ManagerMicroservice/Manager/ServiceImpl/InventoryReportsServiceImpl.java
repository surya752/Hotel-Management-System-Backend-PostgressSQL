package com.ManagerMicroservice.Manager.ServiceImpl;

import com.ManagerMicroservice.Manager.Entity.InventoryReports;
import com.ManagerMicroservice.Manager.Exception.ResourceNotFoundException;
import com.ManagerMicroservice.Manager.Repository.InventoryReportsRepository;
import com.ManagerMicroservice.Manager.Service.InventoryReportsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class InventoryReportsServiceImpl implements InventoryReportsService {
    private InventoryReportsRepository inventoryReportsRepository;

    public InventoryReportsServiceImpl(InventoryReportsRepository inventoryReportsRepository) {
        super();
        this.inventoryReportsRepository = inventoryReportsRepository;
    }

    @Override
    public InventoryReports saveInventoryReports(InventoryReports inventoryReports) {
        return inventoryReportsRepository.save(inventoryReports);
    }

    @Override
    public List<InventoryReports> getAllInventoryReports() {
        return inventoryReportsRepository.findAll();
    }

    @Override
    public InventoryReports GetById(int id) {
        return inventoryReportsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("InventoryReports", "id", id));
    }

    @Override
    public InventoryReports updateInventoryReports(@Validated InventoryReports inventoryReports, int id) {
        InventoryReports existInventoryReports = inventoryReportsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("InventoryReports","Id",id));
        existInventoryReports.setEmployeesalary(inventoryReports.getEmployeesalary());
        existInventoryReports.setTotalincome(inventoryReports.getTotalincome());
        existInventoryReports.setTotalProfit(inventoryReports.getTotalProfit());
        existInventoryReports.setMaintainanceCost(inventoryReports.getMaintainanceCost());
        inventoryReportsRepository.save(existInventoryReports);
        return existInventoryReports;
    }

    @Override
    public void deleteInventoryReports(int id) {
        inventoryReportsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("InventoryReports","Id",id));
        inventoryReportsRepository.deleteById(id);
    }
}
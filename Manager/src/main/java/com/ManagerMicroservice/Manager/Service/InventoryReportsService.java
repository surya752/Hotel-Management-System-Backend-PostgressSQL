package com.ManagerMicroservice.Manager.Service;

import com.ManagerMicroservice.Manager.Entity.InventoryReports;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface InventoryReportsService {
    InventoryReports saveInventoryReports(InventoryReports inventoryReports);
    List<InventoryReports> getAllInventoryReports();
    InventoryReports GetById(int id);
    InventoryReports updateInventoryReports(InventoryReports inventoryReports,int id);
    void deleteInventoryReports(int id);

}
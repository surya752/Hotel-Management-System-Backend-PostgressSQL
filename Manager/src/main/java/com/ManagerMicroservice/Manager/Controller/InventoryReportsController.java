package com.ManagerMicroservice.Manager.Controller;

import com.ManagerMicroservice.Manager.Entity.InventoryReports;
import com.ManagerMicroservice.Manager.Service.InventoryReportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Manager")
public class InventoryReportsController {
    private InventoryReportsService inventoryReportsService;

    public InventoryReportsController(InventoryReportsService inventoryReportsService) {
        super();
        this.inventoryReportsService = inventoryReportsService;
    }
    @PostMapping("/inreports/save")
    public ResponseEntity<InventoryReports> saveInventoryReports(@Valid  @RequestBody InventoryReports inventoryReports){
        return new ResponseEntity<InventoryReports>(inventoryReportsService.saveInventoryReports(inventoryReports), HttpStatus.CREATED);
    }
    @GetMapping("/inreports/list")
    public List<InventoryReports> getAllInventoryReports(){
        return inventoryReportsService.getAllInventoryReports();
    }
    @GetMapping("/inreports/{id}")
    public ResponseEntity<InventoryReports> getById(@PathVariable("id") int id){
        return new ResponseEntity<InventoryReports>(inventoryReportsService.GetById(id),HttpStatus.OK);
    }
    @PutMapping("inreports/edit/{id}")
    public ResponseEntity<InventoryReports> updateInventoryReports(@RequestBody InventoryReports inventoryReports,@PathVariable("id") int id){
        return new ResponseEntity<InventoryReports>(inventoryReportsService.updateInventoryReports(inventoryReports,id),HttpStatus.OK);
    }
    @DeleteMapping("inreports/delete/{id}")
    public ResponseEntity<String> deleteInventoryReports(@PathVariable("id") int id){
        inventoryReportsService.deleteInventoryReports(id);
        return new ResponseEntity<String>("InventoryReports Deleted",HttpStatus.OK);
    }
}

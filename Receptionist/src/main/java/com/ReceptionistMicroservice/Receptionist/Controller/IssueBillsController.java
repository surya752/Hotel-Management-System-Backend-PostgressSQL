package com.ReceptionistMicroservice.Receptionist.Controller;

import com.ReceptionistMicroservice.Receptionist.Entity.IssueBills;
import com.ReceptionistMicroservice.Receptionist.Service.IssueBillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class IssueBillsController {
    private IssueBillsService issueBillsService;

    public IssueBillsController(IssueBillsService issueBillsService) {
        super();
        this.issueBillsService = issueBillsService;
    }
    @PostMapping("/billsave")
    public ResponseEntity<IssueBills> saveIssueBill(@Valid  @RequestBody IssueBills issueBills){
        return new ResponseEntity<IssueBills>(issueBillsService.saveIssueBill(issueBills), HttpStatus.CREATED);
    }
    @GetMapping("/billlist")
    public List<IssueBills> getAllIssueBills(){
        return issueBillsService.getAllIssueBills();
    }
    @GetMapping("bill/{id}")
    public ResponseEntity<IssueBills> getByBillNo(@PathVariable("billNo") int billNo){
        return new ResponseEntity<IssueBills>(issueBillsService.getByBillNo(billNo),HttpStatus.OK);
    }
    @PutMapping("editbill/{id}")
    public ResponseEntity<IssueBills> updateIssueBill(@RequestBody IssueBills issueBills,@PathVariable("billNo") int billNo){
        return new ResponseEntity<IssueBills>(issueBillsService.updateIssueBill(issueBills,billNo),HttpStatus.OK);
    }
    @DeleteMapping("deletebill/{id}")
    public ResponseEntity<String> deleteIssueBill(@PathVariable("billNo") int billNo){
        issueBillsService.deleteIssueBill(billNo);
        return new ResponseEntity<String>("IssueBill Deleted",HttpStatus.OK);
    }
}

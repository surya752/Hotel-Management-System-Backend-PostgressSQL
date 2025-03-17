package com.OwnerMicroservice.Owner.Controller;

import com.OwnerMicroservice.Owner.Entity.SetRates;
import com.OwnerMicroservice.Owner.Service.SetRatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Owner")
public class SetRatesController {
    private SetRatesService setRatesService;

    public SetRatesController(SetRatesService setRatesService) {
        super();
        this.setRatesService = setRatesService;
    }
    @PostMapping("/setratessave")
    public ResponseEntity<SetRates> saveSetRates(@Valid @RequestBody SetRates setRates){
        return new ResponseEntity<SetRates>(setRatesService.saveSetRates(setRates), HttpStatus.CREATED);
    }
    @GetMapping("/setrateslist")
    public List<SetRates> getAllSetRates(){
        return setRatesService.getAllSetRates();

    }
    @GetMapping("/setrates/{id}")
    public ResponseEntity<SetRates> getById(@PathVariable("id") int id){
        return new ResponseEntity<SetRates>(setRatesService.getById(id),HttpStatus.OK);
    }
    @PutMapping("editsetrate/{id}")
    public ResponseEntity<SetRates> updateSetRates(@RequestBody SetRates setRates,@PathVariable("id") int id) {
        return new ResponseEntity<SetRates>(setRatesService.updateSetRates(setRates,id),HttpStatus.OK);

    }
    @DeleteMapping("deletesetrate/{id}")
    public ResponseEntity<String> deleteSetRates(@PathVariable("id") int id){
        setRatesService.deleteSetRates(id);
        return new ResponseEntity<String>("SetRates Deleted",HttpStatus.OK);
    }

}


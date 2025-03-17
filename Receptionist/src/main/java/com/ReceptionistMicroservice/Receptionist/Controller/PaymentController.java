package com.ReceptionistMicroservice.Receptionist.Controller;

import com.ReceptionistMicroservice.Receptionist.Entity.Payment;
import com.ReceptionistMicroservice.Receptionist.Service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }
    @PostMapping("/payment/save")
    public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
    }
    @GetMapping("/payment/list")
    public List<Payment> getAllPayments(){
        return paymentService.getAllpayments();
    }
    @GetMapping("payment/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") int id){
        return new ResponseEntity<Payment>(paymentService.getById(id),HttpStatus.OK);
    }
    @PutMapping("payment/edit/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment,@PathVariable("id") int id){
        return new ResponseEntity<Payment>(paymentService.updatePayment(payment,id),HttpStatus.OK);
    }
    @DeleteMapping("payment/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") int id){
        paymentService.deletePayment(id);
        return new ResponseEntity<String>("Payment Deleted",HttpStatus.OK);
    }
}

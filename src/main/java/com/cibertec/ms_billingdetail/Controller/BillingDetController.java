package com.cibertec.ms_billingdetail.Controller;

import com.cibertec.ms_billingdetail.Model.BillingDetails;
import com.cibertec.ms_billingdetail.Service.BillingDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillingDetController {

    @Autowired
    private BillingDetService billingDetService;

    @GetMapping(path = "/billingdet")
    public ResponseEntity<Object> retriveAll() {
        return billingDetService.getAll();
    }

    @GetMapping(path = "/billingdet/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return billingDetService.getOne(id);
    }

    @PostMapping(path = "/billingdet")
    public ResponseEntity<Object> create(@RequestBody BillingDetails billingDetails) {
        return billingDetService.insert(billingDetails);
    }

    @PutMapping(path = "/billingdet/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody BillingDetails billingDetails) {
        return billingDetService.update(id, billingDetails);
    }

    @DeleteMapping(path = "/billingdet/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return billingDetService.delete(id);
    }

}

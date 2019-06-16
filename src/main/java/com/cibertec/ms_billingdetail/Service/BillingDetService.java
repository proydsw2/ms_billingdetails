package com.cibertec.ms_billingdetail.Service;

import com.cibertec.ms_billingdetail.Model.BillingDetails;
import org.springframework.http.ResponseEntity;

public interface BillingDetService {

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> getOne(Integer id);

    ResponseEntity<Object> insert(BillingDetails billingDetails);

    ResponseEntity<Object> update(Integer id, BillingDetails billingDetails);

    ResponseEntity<Object> delete(Integer id);

}

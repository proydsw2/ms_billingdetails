package com.cibertec.ms_billingdetail.Service.Implement;

import com.cibertec.ms_billingdetail.Model.BillingDetails;
import com.cibertec.ms_billingdetail.Repository.BillingDetRepository;
import com.cibertec.ms_billingdetail.Service.BillingDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BillingDetServiceImpl implements BillingDetService {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    BillingDetRepository billingDetRepository;

    public ResponseEntity<Object> getAll() {
        try {
            List<BillingDetails> billingDetails = billingDetRepository.findAll();

            if (billingDetails == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(billingDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        try {
            Optional<BillingDetails> billingDetail = billingDetRepository.findById(id);

            if (!billingDetail.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(billingDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> insert(BillingDetails billingDetail) {
        try {
            BillingDetails entity = billingDetRepository.save(billingDetail);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getNum_billing_id()).toUri();

            return ResponseEntity.ok().body(entity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> update(Integer id, BillingDetails billingDetail) {
        try {
            Optional<BillingDetails> entity = billingDetRepository.findById(id);

            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            billingDetail.setNum_billing_id(id);
            BillingDetails cust = billingDetRepository.save(billingDetail);
            return ResponseEntity.ok().body(cust);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> delete(Integer id) {

        try {
            Optional<BillingDetails> billingDetail = billingDetRepository.findById(id);
            if (!billingDetail.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            billingDetRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

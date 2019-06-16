package com.cibertec.ms_billingdetail.Repository;

import com.cibertec.ms_billingdetail.Model.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetRepository extends JpaRepository<BillingDetails, Integer> {
}

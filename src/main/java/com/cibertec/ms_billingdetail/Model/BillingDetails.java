package com.cibertec.ms_billingdetail.Model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "billing_detail")
@Data
public class BillingDetails {

    @Id
    @Column(name = "num_billing_id")
    private Integer num_billing_id;

    @Column(name = "num_billing_product_price")
    private Double num_billing_product_price;

    @Column(name = "num_product_id")
    private Integer num_product_id;

}

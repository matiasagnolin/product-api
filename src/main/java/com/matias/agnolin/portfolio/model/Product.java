package com.matias.agnolin.portfolio.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private Double productPrice;
    @Column(name = "product_size")
    private String productSize;

}

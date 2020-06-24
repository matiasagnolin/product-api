package com.matias.agnolin.portfolio.repository;

import com.matias.agnolin.portfolio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductDao extends JpaRepository<Product,Long> {
}

package com.matias.agnolin.portfolio.service;

import com.matias.agnolin.portfolio.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductService {
     List<Product> findAll();
     Page<Product> findAll(Pageable pageable);
     Product findById(Long id);

}

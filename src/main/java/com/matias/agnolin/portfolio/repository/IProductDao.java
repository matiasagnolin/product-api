package com.matias.agnolin.portfolio.repository;

import com.matias.agnolin.portfolio.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product,String> {
}

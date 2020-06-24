package com.matias.agnolin.portfolio.service;

import com.matias.agnolin.portfolio.model.Product;
import com.matias.agnolin.portfolio.repository.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productRepository;


    @Override
    public List<Product> findAll() {
        return (List<Product>)productRepository.findAll();
    }
}

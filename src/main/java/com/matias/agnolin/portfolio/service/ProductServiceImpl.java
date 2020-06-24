package com.matias.agnolin.portfolio.service;

import com.matias.agnolin.portfolio.model.Product;
import com.matias.agnolin.portfolio.repository.IProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    Logger logger =
            LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private IProductDao productRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        ()->new EntityNotFoundException(
                                String.format("Product not found {}",id)
                        )
                );
    }
}

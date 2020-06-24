package com.matias.agnolin.portfolio.controller;

import com.matias.agnolin.portfolio.model.Product;
import com.matias.agnolin.portfolio.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts(){
       List<Product> list =  productService.findAll();

       return list;
    }
}

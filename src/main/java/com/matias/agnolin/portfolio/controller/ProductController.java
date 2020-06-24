package com.matias.agnolin.portfolio.controller;

import com.matias.agnolin.portfolio.model.Product;
import com.matias.agnolin.portfolio.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<Product> getAllProducts(){
      return productService.findAll();
    }

    @GetMapping("/list/page/{page}")
    public Page<Product> getAllProducts(@PathVariable Integer page){
        return productService.findAll(PageRequest.of(page,4));
    }

    @GetMapping("/get/{id}")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public Product getProductById(@PathVariable long id){
        return  productService.findById(id);
    }
}

package com.ecommerce.backend.controller;


import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    // Add Product APi
    @PostMapping
    public Product addProduct (@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Get All Products API
    @GetMapping
    public List<Product> getAllProducts (){
        return productService.getAllProducts();
    }

    // Get Product By ID API
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }




}

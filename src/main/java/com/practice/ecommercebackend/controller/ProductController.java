package com.practice.ecommercebackend.controller;

import com.practice.ecommercebackend.entity.Product;
import com.practice.ecommercebackend.repository.ProductRepository;
import com.practice.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController extends GenericController<Product> {

    @Autowired
    private ProductService productService;

    @GetMapping("/byCategory/{categoryId}")
    public Page<Product> findByCaegory(@PathVariable("categoryId") String categoryId, Pageable pageable){
        return productService.getProductsByCategory(categoryId,pageable);
    }
}

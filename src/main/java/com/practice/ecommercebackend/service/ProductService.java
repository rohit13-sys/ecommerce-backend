package com.practice.ecommercebackend.service;

import com.practice.ecommercebackend.entity.Product;
import com.practice.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getProductsByCategory(String categoryId, Pageable pageable){
        return productRepository.findByCategoryId(categoryId,pageable);
    }
}

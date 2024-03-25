package com.practice.ecommercebackend.controller;

import com.practice.ecommercebackend.entity.Product;
import com.practice.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController extends GenericController<Product> {
}

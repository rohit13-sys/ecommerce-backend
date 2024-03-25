package com.practice.ecommercebackend.controller;

import com.practice.ecommercebackend.entity.Category;
import com.practice.ecommercebackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController extends GenericController<Category> {
}

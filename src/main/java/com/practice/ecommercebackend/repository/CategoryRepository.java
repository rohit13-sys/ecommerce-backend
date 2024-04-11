package com.practice.ecommercebackend.repository;

import com.practice.ecommercebackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category,String> {
}

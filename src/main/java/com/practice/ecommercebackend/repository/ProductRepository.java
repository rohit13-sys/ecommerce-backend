package com.practice.ecommercebackend.repository;

import com.practice.ecommercebackend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends BaseRepository<Product> {

    Page<Product> findByCategoryId(@Param("id") String categoryId, Pageable pageable);

    Page<Product> findByNameContaining(@Param("name") String name,Pageable pageable);
}

package com.practice.ecommercebackend.repository;

import com.practice.ecommercebackend.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String> {
    // Custom methods for generic searching if needed
    List<T> findAll(Specification<T> specification);
}

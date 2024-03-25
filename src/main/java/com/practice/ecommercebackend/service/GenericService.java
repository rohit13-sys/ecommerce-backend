package com.practice.ecommercebackend.service;

import com.practice.ecommercebackend.entity.BaseEntity;
import com.practice.ecommercebackend.repository.BaseRepository;
import com.practice.ecommercebackend.searchcriteria.GenericSpecification;
import com.practice.ecommercebackend.searchcriteria.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService<T extends BaseEntity> {
    private final List<BaseRepository<T>> repositories;

    @Autowired
    public GenericService(List<BaseRepository<T>> repositories) {
        this.repositories = repositories;
    }

    public List<T> search(List<SearchCriteria> criteriaList) {
        List<T> result = null;
        for (BaseRepository<T> repository : repositories) {
            Specification<T> spec = Specification.where(null);
            for (SearchCriteria criteria : criteriaList) {
                spec = spec.and(new GenericSpecification<>(criteria));
            }
            List<T> repositoryResult = repository.findAll(spec);
            if (result == null) {
                result = repositoryResult;
            } else {
                result.addAll(repositoryResult);
            }
        }
        return result;
    }
}

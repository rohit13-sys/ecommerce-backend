package com.practice.ecommercebackend.service;

import com.practice.ecommercebackend.entity.BaseEntity;
import com.practice.ecommercebackend.repository.BaseRepository;
import com.practice.ecommercebackend.searchcriteria.GenericSpecification;
import com.practice.ecommercebackend.searchcriteria.SearchCriteria;
import com.practice.ecommercebackend.searchcriteria.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<SearchCriteria> parseCriteriaList(List<String> criteriaList) {
        List<SearchCriteria> parsedList = new ArrayList<>();
        for (String criteria : criteriaList) {
            String[] parts = criteria.split(":");
            if (parts.length == 3) {
                String key = parts[0];
                SearchOperation operation = SearchOperation.valueOf(parts[1].toUpperCase());
                String value = parts[2];
                parsedList.add(new SearchCriteria(key, operation, value));
            }
        }
        return parsedList;
    }

    public List<T> findAll(){
        List<T> result = new ArrayList<>();
        for (BaseRepository<?> repository : repositories) {

                result.addAll((Collection<? extends T>) repository.findAll());
        }
        return result;
    }
}

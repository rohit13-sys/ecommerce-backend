package com.practice.ecommercebackend.controller;

import com.practice.ecommercebackend.entity.BaseEntity;
import com.practice.ecommercebackend.searchcriteria.SearchCriteria;
import com.practice.ecommercebackend.searchcriteria.SearchOperation;
import com.practice.ecommercebackend.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class GenericController<T extends BaseEntity> {
    @Autowired
    private GenericService<T> service;

    @GetMapping
    public List<T> search(@RequestParam("criteria") List<String> criteriaList) {
        List<SearchCriteria> parsedCriteriaList = parseCriteriaList(criteriaList);
        return service.search(parsedCriteriaList);
    }

    private List<SearchCriteria> parseCriteriaList(List<String> criteriaList) {
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
}

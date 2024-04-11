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
import java.util.Objects;

public class GenericController<T extends BaseEntity> {
    @Autowired
    private GenericService<T> service;

    @GetMapping
    public List<T> search(@RequestParam(value = "criteria",required = false) List<String> criteriaList) {
        if(Objects.nonNull(criteriaList) && !criteriaList.isEmpty()){
            List<SearchCriteria> parsedCriteriaList = service.parseCriteriaList(criteriaList);
            return service.search(parsedCriteriaList);
        }else {
            return service.findAll();
        }
    }

}

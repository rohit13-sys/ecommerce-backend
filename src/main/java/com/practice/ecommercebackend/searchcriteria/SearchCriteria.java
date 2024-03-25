package com.practice.ecommercebackend.searchcriteria;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SearchCriteria {
    private String key;
    private SearchOperation operation;
    private String value;

    public SearchCriteria(String key, SearchOperation operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchCriteria() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public void setOperation(SearchOperation operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Constructors, getters, and setters
}

package com.practice.ecommercebackend.searchcriteria;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericSpecification<T> implements Specification<T> {
    private final SearchCriteria criteria;

    public GenericSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation() == SearchOperation.EQUALS) {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.LIKE) {
            return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (criteria.getOperation() == SearchOperation.GREATER_THAN) {
            return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.LESS_THAN) {
            return builder.lessThan(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}

package com.practice.ecommercebackend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "product_category")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Category extends BaseEntity{
    private String categoryName;

    @OneToMany
    private Set<Product> products;

}

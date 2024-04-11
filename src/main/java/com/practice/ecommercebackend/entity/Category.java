package com.practice.ecommercebackend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
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

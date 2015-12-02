package pl.edu.agh.careSystemService.persistance.product.dao;

import org.springframework.data.jpa.domain.Specification;
import pl.edu.agh.careSystemService.persistance.product.service.ProductQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class ProductSpecification {

    public static Specification<Product> productToSpecyfication(final ProductQuery productQuery) {
        return new Specification<Product>() {

            @Override
            public Predicate toPredicate(Root<Product> root,
                                         CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> restriction = new ArrayList<Predicate>();

                return criteriaBuilder.and(restriction.toArray(new Predicate[]{}));
            }
        };
    }
}

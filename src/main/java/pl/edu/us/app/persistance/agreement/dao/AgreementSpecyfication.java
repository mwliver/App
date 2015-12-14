package pl.edu.us.app.persistance.agreement.dao;

import org.springframework.data.jpa.domain.Specification;
import pl.edu.us.app.persistance.agreement.service.AgreementQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

import static pl.edu.us.app.persistance.Jpa.nestedPath;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class AgreementSpecyfication {

    public static Specification<Agreement> agreementToSpecyfication(final AgreementQuery agreementQuery) {
        return new Specification<Agreement>() {

            @Override
            public Predicate toPredicate(Root<Agreement> root,
                                         CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> restriction = new ArrayList<Predicate>();

                if (agreementQuery.getClientName() != null) {
                    restriction.add(criteriaBuilder.equal(nestedPath(root, "product.client.name"), agreementQuery.getClientName()));
                }

                if (agreementQuery.getClientSurname() != null) {
                    restriction.add(criteriaBuilder.equal(nestedPath(root, "product.client.surname"), agreementQuery.getClientSurname()));
                }

                if (agreementQuery.getProductName() != null) {
                    restriction.add(criteriaBuilder.equal(nestedPath(root, "product.productName"), agreementQuery.getProductName()));
                }

                if (agreementQuery.getProductType() != null) {
                    restriction.add(criteriaBuilder.equal(nestedPath(root, "product.productType"), agreementQuery.getProductType()));
                }

                if (agreementQuery.getSellerName() != null) {
                    restriction.add(criteriaBuilder.equal(root.get("sellerName"), agreementQuery.getSellerName()));
                }

                if (agreementQuery.getSellerSurname() != null) {
                    restriction.add(criteriaBuilder.equal(root.get("sellerSurname"), agreementQuery.getSellerSurname()));
                }

                return criteriaBuilder.and(restriction.toArray(new Predicate[]{}));
            }
        };
    }
}

package pl.edu.agh.careSystemService.persistance.client.dao;

import org.springframework.data.jpa.domain.Specification;
import pl.edu.agh.careSystemService.persistance.client.service.ClientQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

import static pl.edu.agh.careSystemService.persistance.Jpa.nestedPath;

public class ClientSpecification {

	public static Specification<Client> clientToSpecyfication(final ClientQuery clientQuery) {
		return new Specification<Client>() {

			@Override
			public Predicate toPredicate(Root<Client> root,
					CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				ArrayList<Predicate> restriction = new ArrayList<Predicate>();

				if (clientQuery.getName() != null) {
					restriction.add(criteriaBuilder.equal(root.get("name"), clientQuery.getName()));
				}

				if (clientQuery.getSurname() != null) {
					restriction.add(criteriaBuilder.equal(root.get("surname"), clientQuery.getSurname()));
				}

                if (clientQuery.getProductName() != null) {
                    restriction.add(criteriaBuilder.equal(nestedPath(root, "product.productName"), clientQuery.getProductName()));
                }

				return criteriaBuilder.and(restriction.toArray(new Predicate[]{}));
			}
		};
	}
}
package pl.agh.edu.careSystemService.persistance.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import pl.edu.agh.careSystemService.persistance.model.Client;

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
				return criteriaBuilder.and(restriction.toArray(new Predicate[]{}));
			}
		};
	}
}

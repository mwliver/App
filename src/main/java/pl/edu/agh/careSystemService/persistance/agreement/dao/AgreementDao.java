package pl.edu.agh.careSystemService.persistance.agreement.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public interface AgreementDao extends PagingAndSortingRepository<Agreement, Long>, JpaSpecificationExecutor<Agreement> {
}

package pl.edu.us.app.persistance.agreement.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public interface AgreementDao extends PagingAndSortingRepository<Agreement, Long>, JpaSpecificationExecutor<Agreement> {

    @Transactional
    @Modifying
    @Query("update Agreement set signDate =:signDateParam where id =:agreementIdParam")
    void updateAgreementSignDate(@Param("signDateParam") Date signDate,
                                 @Param("agreementIdParam") Long agreementId);

}

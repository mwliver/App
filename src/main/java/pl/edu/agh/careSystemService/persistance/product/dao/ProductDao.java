package pl.edu.agh.careSystemService.persistance.product.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ProductDao extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Transactional
    @Modifying
    @Query("update Product set createDate =:createDateParam where id =:productIdParam")
    void updateProductCreateDate(@Param("createDateParam") Date createDate,
                                 @Param("productIdParam") Long productId);

}

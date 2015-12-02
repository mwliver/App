package pl.edu.agh.careSystemService.persistance.client.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.careSystemService.persistance.client.service.ClientDto;

import java.util.List;

public interface ClientDao extends PagingAndSortingRepository<Client, Long>, JpaSpecificationExecutor<Client> {
	
	@Query("select new pl.edu.agh.careSystemService.persistance.client.service.ClientDto(c.pesel, p.createDate, a.signDate, c.id, p.id, a.id) from Agreement a left join a.product p left join p.client c where c.name =:nameParam and c.surname =:surnameParam and p.productType =:productTypeParam and p.productName =:productNameParam and a.sellerName =:sellerNameParam and a.sellerSurname =:sellerSurnameParam")
	List<ClientDto> getClientDto(@Param("nameParam") String name,
								 @Param("surnameParam") String surname,
								 @Param("productNameParam") String productName,
								 @Param("productTypeParam") String productType,
								 @Param("sellerNameParam") String sellerName,
								 @Param("sellerSurnameParam") String sellerSurname);

	@Transactional
	@Modifying
	@Query("update Client set pesel =:peselParam where id =:clientIdParam")
	void updateClientPesel(@Param("peselParam") String pesel,
						   @Param("clientIdParam") Long clientId);
}

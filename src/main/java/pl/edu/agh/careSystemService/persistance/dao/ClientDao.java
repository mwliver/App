package pl.edu.agh.careSystemService.persistance.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.edu.agh.careSystemService.persistance.service.ClientDto;

import java.util.List;

public interface ClientDao extends PagingAndSortingRepository<Client, Long>, JpaSpecificationExecutor<Client> {
	
	@Query("select new pl.edu.agh.careSystemService.persistance.service.ClientDto(c.name, c.surname, c.id) from Client c where c.name = :nameParam")
	List<ClientDto> getClientDto(@Param("nameParam") String name);
}

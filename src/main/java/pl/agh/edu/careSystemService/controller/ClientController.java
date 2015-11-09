package pl.agh.edu.careSystemService.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.agh.edu.careSystemService.persistance.specification.ClientQuery;
import pl.agh.edu.careSystemService.persistance.specification.ClientSpecification;
import pl.edu.agh.careSystemService.persistance.dao.ClientDao;
import pl.edu.agh.careSystemService.persistance.dao.ClientDto;
import pl.edu.agh.careSystemService.persistance.model.Client;


@RestController
public class ClientController {
	
	private static org.slf4j.Logger log = LoggerFactory
			.getLogger(ClientController.class);

	@Autowired
	ClientDao clientDao;
	
	@RequestMapping(value = "/find/client")
	public List<Client> getClient() {
		long startTime = System.currentTimeMillis();
		ClientQuery query = new ClientQuery();
		query.setName("Jan");
		List<Client> toReturn = (List<Client>) ClientSpecification.clientToSpecyfication(query);
		long endTime = System.currentTimeMillis();
		Date time = new Date(endTime - startTime);
		log.info("Duration of getClient : %s", time);
		return toReturn;
	}
	
	@RequestMapping(value = "/find/clientDto")
	public List<ClientDto> getClientDto() {
		long startTime = System.currentTimeMillis();
		List<ClientDto> toReturn = clientDao.getClientDto("Jan");
		long endTime = System.currentTimeMillis();
		return toReturn;
	}
}

package pl.edu.agh.careSystemService.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.careSystemService.persistance.client.dao.Client;
import pl.edu.agh.careSystemService.persistance.client.dao.ClientDao;
import pl.edu.agh.careSystemService.persistance.client.dao.ClientSpecification;
import pl.edu.agh.careSystemService.persistance.client.service.ClientDto;
import pl.edu.agh.careSystemService.persistance.client.service.ClientQuery;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class ClientController {
	
	private static org.slf4j.Logger log = LoggerFactory
			.getLogger(ClientController.class);

	@Autowired
	ClientDao clientDao;
	
	@RequestMapping(value = "/find/client", method = RequestMethod.GET)
	public List<Client> getClient() {
		long startTime = System.currentTimeMillis();
		ClientQuery query = new ClientQuery();
		query.setName("Jan");
		List<Client> toReturn = clientDao.findAll(ClientSpecification.clientToSpecyfication(query));
		long endTime = System.currentTimeMillis();
		Date time = new Date(endTime - startTime);
		log.info("DURATION OF CLIENT : " + millisToShortDHMS(endTime - startTime));
		return toReturn;
	}
	
	@RequestMapping(value = "/find/clientDto", method = RequestMethod.GET)
	public List<ClientDto> getClientDto() {
		long startTime = System.currentTimeMillis();
		List<ClientDto> toReturn = clientDao.getClientDto("Jan");
		long endTime = System.currentTimeMillis();
		Date time = new Date(endTime - startTime);
		log.info("DURATION OF GET CLIENTDTO : " + millisToShortDHMS(endTime - startTime));
		return toReturn;
	}

	public static String millisToShortDHMS(long duration) {
		String res = "";
		long days  = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration)
				- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
		if (days == 0) {
			res = String.format("%02dh:%02dm:%02ds", hours, minutes, seconds);
		}
		else {
			res = String.format("%dd%02dh:%02dm:%02ds", days, hours, minutes, seconds);
		}
		return res;
	}
}

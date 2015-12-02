package pl.edu.agh.careSystemService.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.careSystemService.persistance.agreement.dao.Agreement;
import pl.edu.agh.careSystemService.persistance.agreement.dao.AgreementDao;
import pl.edu.agh.careSystemService.persistance.agreement.dao.AgreementSpecyfication;
import pl.edu.agh.careSystemService.persistance.agreement.service.AgreementQuery;
import pl.edu.agh.careSystemService.persistance.client.dao.ClientDao;
import pl.edu.agh.careSystemService.persistance.client.service.ClientDto;
import pl.edu.agh.careSystemService.persistance.product.dao.ProductDao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class ClientController {
	
	private static org.slf4j.Logger log = LoggerFactory
			.getLogger(ClientController.class);

	@Autowired
	ClientDao clientDao;

	@Autowired
	AgreementDao agreementDao;

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/find/client", method = RequestMethod.GET)
	public String getClient() {
		long startTime = System.currentTimeMillis();
		AgreementQuery agreementQuery = new AgreementQuery();
		agreementQuery.setClientName("Jan");
		agreementQuery.setClientSurname("Kowalski");
		agreementQuery.setProductName("Najdluzsza nazwa produktu na swiecie jakiej zadna firma by nie dala produktowi poniewaz jest ona tak dluga ze zapamietac klientowi by sie jej nie udalo");
		agreementQuery.setProductType("Najdluzszy typ produktu bedacy tak niesamowicie niepraktycznym ze zadna firma by sie na niego nie zdecydowala my jednak na potrzeby edukacyjne pozwolimy sobie na taka nazwe");
		agreementQuery.setSellerName("Kamil");
		agreementQuery.setSellerSurname("Niski");
		List<Agreement> agreements = agreementDao.findAll(AgreementSpecyfication.agreementToSpecyfication(agreementQuery));
		log.info("LIST SIZE" + agreements.size());
		for (Agreement agreement : agreements) {
			agreement.getProduct().getClient().setPesel("1111");
			clientDao.save(agreement.getProduct().getClient());

			agreement.getProduct().setCreateDate(new Date());
			productDao.save(agreement.getProduct());

			agreement.setSignDate(new Date());
			agreementDao.save(agreement);
		}

		long endTime = System.currentTimeMillis();
		log.info("DURATION OF CLIENT : " + millisToShortDHMS(endTime - startTime));
		return millisToShortDHMS(endTime - startTime);
	}

	@RequestMapping(value = "/find/clientDto", method = RequestMethod.GET)
	public String getClientDto() {
		long startTime = System.currentTimeMillis();
		List<ClientDto> toReturn = clientDao.getClientDto(
				"Jan",
				"Kowalski",
				"Najdluzsza nazwa produktu na swiecie jakiej zadna firma by nie dala produktowi poniewaz jest ona tak dluga ze zapamietac klientowi by sie jej nie udalo",
				"Najdluzszy typ produktu bedacy tak niesamowicie niepraktycznym ze zadna firma by sie na niego nie zdecydowala my jednak na potrzeby edukacyjne pozwolimy sobie na taka nazwe",
				"Kamil",
				"Niski");

		log.info("LIST SIZE" + toReturn.size());
		for (ClientDto clientDto : toReturn) {
			if (clientDto.getClientId() != null) {
				clientDao.updateClientPesel("1111", clientDto.getClientId());
			}
			if (clientDto.getAgreementId() != null) {
				agreementDao.updateAgreementSignDate(new Date(), clientDto.getAgreementId());
			}
			if (clientDto.getProductId() != null) {
				productDao.updateProductCreateDate(new Date(), clientDto.getProductId());
			}

		}
		long endTime = System.currentTimeMillis();
		log.info("DURATION OF GET CLIENTDTO : " + millisToShortDHMS(endTime - startTime));
		return millisToShortDHMS(endTime - startTime);
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

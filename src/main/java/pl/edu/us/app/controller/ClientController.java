package pl.edu.us.app.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.us.app.persistance.agreement.dao.Agreement;
import pl.edu.us.app.persistance.agreement.dao.AgreementDao;
import pl.edu.us.app.persistance.agreement.dao.AgreementSpecyfication;
import pl.edu.us.app.persistance.agreement.service.AgreementQuery;
import pl.edu.us.app.persistance.client.dao.ClientDao;
import pl.edu.us.app.persistance.client.service.ClientDto;
import pl.edu.us.app.persistance.product.dao.ProductDao;
import pl.edu.us.app.utils.TimeUtils;

import java.util.Date;
import java.util.List;


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
		for (Agreement agreement : agreements) {
			agreement.getProduct().getClient().setPesel("1111");
			clientDao.save(agreement.getProduct().getClient());

			agreement.getProduct().setCreateDate(new Date());
			productDao.save(agreement.getProduct());

			agreement.setSignDate(new Date());
			agreementDao.save(agreement);
		}

		long endTime = System.currentTimeMillis();
		return TimeUtils.millisToShortDHMS(endTime - startTime);
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
		return TimeUtils.millisToShortDHMS(endTime - startTime);
	}
}

package pl.edu.agh.careSystemService.persistance.client.service;

import java.io.Serializable;
import java.util.Date;

public class ClientDto implements Serializable {

	private String clientPesel;
	private Date productCreateDate;
	private Date agreementSignDate;

	private Long clientId;
	private Long productId;
	private Long agreementId;

	public ClientDto(String clientPesel,
					 Date productCreateDate,
					 Date agreementSignDate,
					 Long clientId,
					 Long productId,
					 Long agreementId) {

		this.clientPesel = clientPesel;
		this.productCreateDate = productCreateDate;
		this.agreementSignDate = agreementSignDate;
		this.clientId = clientId;
		this.productId = productId;
		this.agreementId = agreementId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(Long agreementId) {
		this.agreementId = agreementId;
	}

	public String getClientPesel() {
		return clientPesel;
	}

	public void setClientPesel(String clientPesel) {
		this.clientPesel = clientPesel;
	}

	public Date getProductCreateDate() {
		return productCreateDate;
	}

	public void setProductCreateDate(Date productCreateDate) {
		this.productCreateDate = productCreateDate;
	}

	public Date getAgreementSignDate() {
		return agreementSignDate;
	}

	public void setAgreementSignDate(Date agreementSignDate) {
		this.agreementSignDate = agreementSignDate;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}

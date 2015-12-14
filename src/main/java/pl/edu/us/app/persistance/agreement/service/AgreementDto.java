package pl.edu.us.app.persistance.agreement.service;

import java.io.Serializable;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class AgreementDto implements Serializable {

    public AgreementDto(String clientName,
                        String clientSurname,
                        String agreementSellerName,
                        String agreementSellerSurname,
                        String productName,
                        String productSurname) {

        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.agreementSellerName = agreementSellerName;
        this.agreementSellerName = agreementSellerSurname;
        this.productName = productName;
        this.productSurname = productSurname;
    }

    private String clientName;
    private String clientSurname;
    private String agreementSellerName;
    private String agreementSellerSurname;
    private String productName;
    private String productSurname;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getAgreementSellerName() {
        return agreementSellerName;
    }

    public void setAgreementSellerName(String agreementSellerName) {
        this.agreementSellerName = agreementSellerName;
    }

    public String getAgreementSellerSurname() {
        return agreementSellerSurname;
    }

    public void setAgreementSellerSurname(String agreementSellerSurname) {
        this.agreementSellerSurname = agreementSellerSurname;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSurname() {
        return productSurname;
    }

    public void setProductSurname(String productSurname) {
        this.productSurname = productSurname;
    }
}

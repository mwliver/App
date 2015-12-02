package pl.edu.agh.careSystemService.persistance.agreement.dao;

import pl.edu.agh.careSystemService.persistance.product.dao.Product;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (C) Coderion sp. z o.o
 */
@Entity
@Table(name = "agreement")
public class Agreement {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "sign_date")
    private Date signDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

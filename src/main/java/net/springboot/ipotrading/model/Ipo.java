package net.springboot.ipotrading.model;

import javax.persistence.*;

@Entity
@Table(name = "ipo")
public class Ipo {
    private Long id;
    private String userName;
    private String companyName;
    private double marketCap;
    private double availableForSale;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getAvailableForSale() {
        return availableForSale;
    }

    public void setAvailableForSale(double availableForSale) {
        this.availableForSale = availableForSale;
    }




}

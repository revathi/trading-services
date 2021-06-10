package net.springboot.ipotrading.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ipo")
public class Ipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String companyName;
    private double marketCap;
    private double availableForSale;
    //ipo quote models
    private String description;
    private String issueDate;
    private Long issueSize;
    private double issuePrice;
    private long lotSize;
    private String closingDate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Long getIssueSize() {
        return issueSize;
    }

    public void setIssueSize(Long issueSize) {
        this.issueSize = issueSize;
    }

    public double getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(double issuePrice) {
        this.issuePrice = issuePrice;
    }

    public long getLotSize() {
        return lotSize;
    }

    public void setLotSize(long lotSize) {
        this.lotSize = lotSize;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ipo ipo = (Ipo) o;
        return Double.compare(ipo.marketCap, marketCap) == 0 && Double.compare(ipo.availableForSale, availableForSale) == 0 && Double.compare(ipo.issuePrice, issuePrice) == 0 && lotSize == ipo.lotSize && Objects.equals(id, ipo.id) && Objects.equals(userName, ipo.userName) && Objects.equals(companyName, ipo.companyName) && Objects.equals(description, ipo.description) && Objects.equals(issueDate, ipo.issueDate) && Objects.equals(issueSize, ipo.issueSize) && Objects.equals(closingDate, ipo.closingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, companyName, marketCap, availableForSale, description, issueDate, issueSize, issuePrice, lotSize, closingDate);
    }

}

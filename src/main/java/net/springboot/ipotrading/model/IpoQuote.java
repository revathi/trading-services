package net.springboot.ipotrading.model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class IpoQuote {

    private String description;
    private String issueDate;
    private Long issueSize;
    private double issuePrice;
    private long lotSize;
    private String closingDate;

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
    public String toString() {
        return "IpoQuote{" +
                "description='" + description + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", issueSize=" + issueSize +
                ", issuePrice=" + issuePrice +
                ", lotSize=" + lotSize +
                ", closingDate='" + closingDate + '\'' +
                '}';
    }


}

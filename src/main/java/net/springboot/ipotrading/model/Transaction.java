package net.springboot.ipotrading.model;


import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    enum TransactionType {
       Buy, Sell
    }
    enum OrderType {
        Market,Limit
    }


    private String userName;
    private TransactionType type;
    private double quantity;
    private OrderType order;
    private double priceLimit;
    private double marketPrice;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public OrderType getOrder() {
        return order;
    }

    public void setOrder(OrderType order) {
        this.order = order;
    }

    public double getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(double priceLimit) {
        this.priceLimit = priceLimit;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }



}

package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.Transaction;

import java.util.List;

public interface TransactionService {

    void save(Transaction transaction);
    List<Transaction> findAll();
    List<Transaction> findByUserName(String userName);
    Transaction findByUserNameAndProductName(String userName,String productName);


}

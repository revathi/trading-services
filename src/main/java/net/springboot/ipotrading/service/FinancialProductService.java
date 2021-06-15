package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;

import java.util.List;
public interface FinancialProductService {
    void generateAssets();
    List<FinancialProduct> findAll();
    PrimeResponse saveTransactionForFP(Transaction req);
}

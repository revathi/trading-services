package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.FinancialProduct;
import java.util.List;
public interface FinancialProductService {
    void generateAssets();
    List<FinancialProduct> findAll();
}

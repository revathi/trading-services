package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.repository.FinancialProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class FinancialProductServiceImpl implements FinancialProductService {
    @Autowired
    private FinancialProductRepository financialProductRepository;
    @Override
    public void generateAssets( ) {
        List<FinancialProduct> financilaproducts = new ArrayList<>();
        financilaproducts.add(new FinancialProduct("Short term gold","WM001","FP","WEALTH",3900,4000,"available for a short period (1- 3 years),You have the option of breaking the lock-in period, however you will be required to pay a penalty in that case."));
        financilaproducts.add(new FinancialProduct("Long term platinum","WM002","FP","WEALTH",2000,2100,"Long term platinum charges a flat annual investment management fee of 0.5% of the market value of a client's portfolio"));
        financilaproducts.add(new FinancialProduct("Income Plus","I001","FP","INCOME",9980,10000,"Income Plus is pay no interest until maturity"));
        financialProductRepository.saveAll(financilaproducts);
    }
    public List<FinancialProduct> findAll() {
        return financialProductRepository.findAll();
    }
}


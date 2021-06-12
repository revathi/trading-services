package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.Ipo;
import net.springboot.ipotrading.repository.FinancialProductRepository;
import net.springboot.ipotrading.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FinancialProductServiceImpl implements FinancialProductService {

    @Autowired
    private FinancialProductRepository financialProductRepository;


    @Override
    public void generateAssets( ) {
        List<FinancialProduct> financilaproducts = new ArrayList<>();
        financilaproducts.add(new FinancialProduct("Short term gold","WM001","FP","WEALTH",3900,4000,"available for a short period (1- 3 years),You have the option of breaking the lock-in period, however you will be required to pay a penalty in that case."));
        financilaproducts.add(new FinancialProduct("Capital Wealth Management","CW001","FP","WEALTH",2000,2100,"Capital Wealth Management charges a flat annual investment management fee of 0.5% of the market value of a client's portfolio"));
        financilaproducts.add(new FinancialProduct("Zero coupon bonds","Z001","FP","WEALTH",9980,10000,"zero coupon bonds pay no interest until maturity"));
        financilaproducts.add(new FinancialProduct("Real estate investment trust india","PM001","FP","WEALTH",355.60,351.70,"REITs are corporations that manage the portfolios of high-value real estate properties and mortgages"));
        financilaproducts.add(new FinancialProduct("impecca Money market account","IM001","FP","WEALTH",700000,700000,"Ideal for an investment horizon of at least 3-6months"));
        financialProductRepository.saveAll(financilaproducts);
    }


    public List<FinancialProduct> findAll() {
        if (financialProductRepository.findAll().isEmpty()) {
            generateAssets();
        }
        return financialProductRepository.findAll();
    }
}


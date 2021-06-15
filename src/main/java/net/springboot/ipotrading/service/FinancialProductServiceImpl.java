package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.repository.FinancialProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class FinancialProductServiceImpl implements FinancialProductService {
    @Autowired
    private FinancialProductRepository financialProductRepository;

    @Autowired
    private TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(FinancialProductServiceImpl.class);

    @Override
    public void generateAssets( ) {
        List<FinancialProduct> financilaproducts = new ArrayList<>();
        financilaproducts.add(new FinancialProduct("Short term gold","WM001","FP","WEALTH",3900,4000,"available for a short period (1- 3 years),You have the option of breaking the lock-in period, however you will be required to pay a penalty in that case."));
        financilaproducts.add(new FinancialProduct("Long term platinum","WM002","FP","WEALTH",2000,2100,"Long term platinum charges a flat annual investment management fee of 0.5% of the market value of a client's portfolio"));
        financilaproducts.add(new FinancialProduct("Income Plus","I001","FP","INCOME",9980,10000,"Income Plus is pay no interest until maturity"));
        financialProductRepository.saveAll(financilaproducts);
    }
    @Override
    public List<FinancialProduct> findAll() {
        if (financialProductRepository.findAll().isEmpty()) {
            generateAssets();
        }
        return financialProductRepository.findAll();
    }

    @Override
    public PrimeResponse saveTransactionForFP(Transaction req) {
        PrimeResponse fpShopResponse = new PrimeResponse();
        try {
            Transaction transEntryProduct = transactionService.findByUserNameAndProductID(req.getUserName(), req.getProductID());
            if (transEntryProduct == null) {
                List<FinancialProduct> financialProducts = findAll();
                for (FinancialProduct productRequested : financialProducts) {
                    if (productRequested.getProductID().equals(req.getProductID())) {
                        transEntryProduct = new Transaction();
                        transEntryProduct.setUserName(req.getUserName());
                        transEntryProduct.setProductID(req.getProductID());
                        transEntryProduct.setProductName(productRequested.getProductName());
                        transEntryProduct.setProductType(productRequested.getProductType());
                        transEntryProduct.setBuyPrice(productRequested.getBuyPrice());
                        transEntryProduct.setSubcategory(productRequested.getSubcategory());
                        transEntryProduct.setMarketPrice(productRequested.getMarketPrice());
                        transEntryProduct.setQuantity(1); //the quenatity is always 1 for FPproducts
                        transactionService.save(transEntryProduct);
                        fpShopResponse.setMessage("Product added to your portfolio");
                        return fpShopResponse;
                    }
                }
            }
            else {
                fpShopResponse.setMessage("User already owned the product");
            }
        } catch (Exception e) {
            fpShopResponse.setMessage("An error handling fpshop buy");
            logger.debug("exception while handing fpshop buy for req");

            e.printStackTrace();
        }

        return fpShopResponse;
    }
}


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
        financilaproducts.add(createAsset("Short term gold","WM001","FP","WEALTH",1000L));
        financilaproducts.add(createAsset("Capital Wealth Management","CW001","FP","WEALTH",6000L));
        financilaproducts.add(createAsset("Fortune gold2021","F001","FP","WEALTH",3000L));
        financilaproducts.add(createAsset("Premium wealth scheme","PM001","FP","WEALTH",2000L));
        financilaproducts.add(createAsset("impecca wealth advisors","IM001","FP","WEALTH",4000L));
        financialProductRepository.saveAll(financilaproducts);
    }

    public FinancialProduct createAsset(String name ,String productId, String producttype, String subcategory,Long marketPrice) {
        FinancialProduct financialProduct = new FinancialProduct();
        financialProduct.setProductName(name);
        financialProduct.setProductID(productId);
        financialProduct.setProductType(producttype);
        financialProduct.setSubcategory(subcategory);
        financialProduct.setMarketPrice(marketPrice);
        return financialProduct;
    }
    public List<FinancialProduct> findAll() {

        if(financialProductRepository.findAll().isEmpty()){
            generateAssets();

        }
       return financialProductRepository.findAll();}
}


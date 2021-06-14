package net.springboot.ipotrading;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.repository.TransactionRepository;
import net.springboot.ipotrading.service.FinancialProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import net.springboot.ipotrading.service.TransactionService;
@RestController
@CrossOrigin
public class FinancialProductController {
    @Autowired
    private FinancialProductService fpService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private PrimeResponse primeResponse;
    Transaction tp;
    @RequestMapping(value = "/fpshop/catalog", method = RequestMethod.GET)
    public List<FinancialProduct> findAll( ) {
        fpService.generateAssets();
        return fpService.findAll();
    }
    @RequestMapping(value = "/fpshop/buy", method = RequestMethod.POST)
    public PrimeResponse fpProduct(@RequestBody Transaction transaction ) {
        try {
            tp = transactionService.findByUserNameAndProductID(transaction.getUserName(), transaction.getProductID());
            if(tp == null)
            {
                fpService.generateAssets();
                List<FinancialProduct> fp1 = fpService.findAll();
                for (int i = 0; i <= fp1.size(); i++) {
                    FinancialProduct f1 = fp1.get(i);
                    if (f1.getProductID().equals(transaction.getProductID())) {
                        tp.setUserName(transaction.getUserName());
                        tp.setProductID(transaction.getProductID());
                        tp.setProductName(f1.getProductName());
                        tp.setProductType(f1.getProductType());
                        tp.setBuyPrice(f1.getBuyPrice());
                        tp.setSubcategory(f1.getSubcategory());
                        tp.setMarketPrice(f1.getMarketPrice());
                        tp.setQuantity(1);
                        transactionService.save(transaction);
                        primeResponse.setMessage("Product added to your portfolio");
                        return primeResponse;
                    }
                }
            }
            primeResponse.setMessage("User already owned the product");
        }
        catch(NullPointerException e)
        {
            fpService.generateAssets();
            List<FinancialProduct> fp1 = fpService.findAll();
            for (int i = 0; i <= fp1.size(); i++) {
                FinancialProduct f1 = fp1.get(i);

                if (f1.getProductID().equals(transaction.getProductID())) {
                    transaction.setUserName(transaction.getUserName());
                    transaction.setProductID(transaction.getProductID());
                    transaction.setProductName(f1.getProductName());
                    transaction.setProductType(f1.getProductType());
                    transaction.setBuyPrice(f1.getBuyPrice());
                    transaction.setSubcategory(f1.getSubcategory());
                    transaction.setMarketPrice(f1.getMarketPrice());
                    transaction.setQuantity(1);
                    transactionService.save(transaction);
                    primeResponse.setMessage("Product added to your portfolio");
                    return primeResponse;
                }
                primeResponse.setMessage("User already owned the product");
            }

        }
        return primeResponse;
    }
    @RequestMapping(value = "/fpshop/findAll", method = RequestMethod.GET)
    public List<Transaction> findAllTransactions() {
        return transactionService.findAll();
    }
}

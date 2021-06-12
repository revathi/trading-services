package net.springboot.ipotrading;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.service.FinancialProductService;
import net.springboot.ipotrading.service.IpoService;
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
    private PrimeResponse primeResponse;

    @RequestMapping(value = "/fpshop/catalog", method = RequestMethod.GET)
    public List<FinancialProduct> findAll( ) {

        fpService.generateAssets();
        return fpService.findAll();
    }
    @RequestMapping(value = "/fpshop/buy", method = RequestMethod.POST)
    public PrimeResponse fpProduct(@RequestBody Transaction transaction ) {
        transactionService.save(transaction);
        primeResponse.setMessage("Product added to your portfolio");
        return primeResponse;
    }
    @RequestMapping(value = "/fpshop/findAll", method = RequestMethod.GET)
    public List<Transaction> findAllTransactions() {



        return transactionService.findAll();
    }


}

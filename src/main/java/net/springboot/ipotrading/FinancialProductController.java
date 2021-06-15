package net.springboot.ipotrading;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.repository.TransactionRepository;
import net.springboot.ipotrading.service.FinancialProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(FinancialProductController.class);

    @RequestMapping(value = "/fpshop/catalog", method = RequestMethod.GET)
    public List<FinancialProduct> findAll( ) {
        return fpService.findAll();
    }

    @RequestMapping(value = "/fpshop/buy", method = RequestMethod.POST)
    public PrimeResponse fpProduct(@RequestBody Transaction req) {
        return (fpService.saveTransactionForFP(req));
    }
    @RequestMapping(value = "/fpshop/findAll", method = RequestMethod.GET)
    public List<Transaction> findAllTransactions() {
        return transactionService.findAll();
    }
}

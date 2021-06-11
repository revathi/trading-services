package net.springboot.ipotrading;

import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private PrimeResponse buyResponse;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping(value = "/bns/buy", method = RequestMethod.POST)
    public PrimeResponse buyProduct(@RequestBody Transaction transaction ) {
        transactionService.save(transaction);
        buyResponse.setMessage("Product added to your portfolio");
        return buyResponse;
    }

    @RequestMapping(value = "/bns/sell", method = RequestMethod.POST)
    public PrimeResponse sellProduct(@RequestBody Transaction transaction ) {
        transactionService.save(transaction);
        buyResponse.setMessage("Product initiated to sale");
        return buyResponse ;

    }
    @RequestMapping(value = "/bns/findAll", method = RequestMethod.GET)
    public List<Transaction> findAllTransactions() {


       // return "Product added to your portfolio" ;
        return transactionService.findAll();

    }

}

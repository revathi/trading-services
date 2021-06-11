package net.springboot.ipotrading;

import net.springboot.ipotrading.model.BuyResponse;
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
    private BuyResponse buyResponse;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping(value = "/bns/buy", method = RequestMethod.POST)
    public BuyResponse buyProduct(@RequestBody Transaction transaction ) {
        buyResponse.setMessage("Product added to your portfolio");
        transactionService.save(transaction);
        return buyResponse;
    }

    @RequestMapping(value = "/bns/sell", method = RequestMethod.POST)
    public BuyResponse sellProduct(@RequestBody Transaction transaction ) {
        buyResponse.setMessage("Product initiated to sale");
        transactionService.save(transaction);
        return buyResponse ;

    }
    @RequestMapping(value = "/bns/findAll", method = RequestMethod.GET)
    public List<Transaction> findAllTransactions() {


       // return "Product added to your portfolio" ;
        return transactionService.findAll();

    }

}

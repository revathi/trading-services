package net.springboot.ipotrading;

import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping(value = "/bns/buy", method = RequestMethod.POST)
    public String buyProduct(@RequestBody Transaction transaction ) {

        transactionService.save(transaction);
        return "Product added to your portfolio";
    }

    @RequestMapping(value = "/bns/sell", method = RequestMethod.POST)
    public String sellProduct(@RequestBody Transaction transaction ) {

        transactionService.save(transaction);
        return "Product added to your portfolio" ;

    }

}

package net.springboot.ipotrading;

import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.model.Transaction;
import net.springboot.ipotrading.service.TransactionService;
import net.springboot.ipotrading.repository.TransactionRepository;
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
    private TransactionRepository transactionRepository;
    @Autowired
    private PrimeResponse primeResponse;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping(value = "/bns/buy", method = RequestMethod.POST)
    public PrimeResponse buyProduct(@RequestBody Transaction transaction ) {
        transaction.setUserName(UserController.UsernameReturn());
        transaction.setProductType("Stock");
        transaction.setSubcategory("Stock");
        try {
            Transaction to = transactionService.findByUserNameAndProductName(transaction.getUserName(), transaction.getProductName());

                double y = to.getQuantity()+transaction.getQuantity();
                to.setQuantity(y);
                to.setBuyPrice(transaction.getBuyPrice());
                to.setMarketPrice(transaction.getMarketPrice());
                transactionRepository.save(to);
                primeResponse.setMessage("Product Added to your Portfolio");
                return primeResponse;



        }
        catch(Exception e){

                transactionService.save(transaction);
                primeResponse.setMessage("Product Added to your Portfolio");
                return primeResponse;

        }
       //primeResponse.setMessage("Could not add your product to portfolio");
        //return primeResponse;
    }

    @RequestMapping(value = "/bns/sell", method = RequestMethod.POST)
    public PrimeResponse sellProduct(@RequestBody Transaction transaction ) {
        transaction.setUserName(UserController.UsernameReturn());
        transaction.setProductType("Stock");
        transaction.setSubcategory("Stock");
        try {
            Transaction t1 = transactionService.findByUserNameAndProductName(transaction.getUserName(), transaction.getProductName());
            if(t1.getQuantity()>=transaction.getQuantity())
            {
                double x = t1.getQuantity()-transaction.getQuantity();
                t1.setQuantity(x);
                transactionRepository.save(t1);
                primeResponse.setMessage("Product Initiated For Sale");
                return primeResponse;
            }

        }
        catch(Exception e) {
            primeResponse.setMessage("Enter owned stock details correctly");
            return primeResponse;
        }
        return primeResponse;

    }
    @RequestMapping(value = "/bns/findAll", method = RequestMethod.GET)
    public List<Transaction> findAllTransactions() {


       // return "Product added to your portfolio" ;
        return transactionService.findAll();

    }
    @RequestMapping(value="/bns/findByUName/{userName}",method=RequestMethod.GET)
    public List<Transaction> findByUserName(@PathVariable String userName)
    {
        List<Transaction> l1 = transactionService.findByUserName(userName);
        return l1;
    }

}

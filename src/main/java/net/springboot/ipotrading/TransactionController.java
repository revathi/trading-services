package net.springboot.ipotrading;

import net.springboot.ipotrading.model.FinancialProduct;
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

        try {
            Transaction to = transactionService.findByUserNameAndProductID(transaction.getUserName(), transaction.getProductID());

                double updatedQuantity = to.getQuantity()+transaction.getQuantity();
                to.setQuantity(updatedQuantity);
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

    }

    @RequestMapping(value = "/bns/sell", method = RequestMethod.POST)
    public PrimeResponse sellProduct(@RequestBody Transaction transaction ) {

        try {
            Transaction t1 = transactionService.findByUserNameAndProductID(transaction.getUserName(), transaction.getProductID());
            if(t1.getQuantity()>=transaction.getQuantity())
            {
                double updatedQuantity = t1.getQuantity()-transaction.getQuantity();
                if(updatedQuantity==0.0)
                {
                    transactionService.delete(t1);
                    primeResponse.setMessage("Product Initiated For Sale and total quantity of the stock has been sold");
                }
                else {
                    t1.setQuantity(updatedQuantity);
                    transactionRepository.save(t1);
                    primeResponse.setMessage("Product Initiated For Sale");
                    return primeResponse;
                }
            }
            else{
                primeResponse.setMessage("Enter Quantity details less than are equal to "+t1.getQuantity());
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
        return transactionService.findAll();
    }

    @RequestMapping(value="/bns/findByUName/{userName}",method=RequestMethod.GET)
    public List<Transaction> findByUserName(@PathVariable String userName)
    {
        return transactionService.findByUserName(userName);
    }

}

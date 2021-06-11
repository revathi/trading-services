package net.springboot.ipotrading;

import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.service.FinancialProductService;
import net.springboot.ipotrading.service.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class FinancialProductController {

    @Autowired
    private FinancialProductService fpService;


    @RequestMapping(value = "/fpshop/catalog", method = RequestMethod.GET)
    public List<FinancialProduct> findAll( ) {

        fpService.generateAssets();
        return fpService.findAll();
    }



}

package net.springboot.ipotrading;

import net.springboot.ipotrading.model.Ipo;
import net.springboot.ipotrading.model.PrimeResponse;
import net.springboot.ipotrading.service.IpoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class IpoController {
    @Autowired
    private IpoService ipoService;
    @Autowired
    private PrimeResponse response;

    private static final Logger logger = LoggerFactory.getLogger(IpoController.class);

    @RequestMapping(value = "/ipo/register", method = RequestMethod.POST)
    public PrimeResponse ipoRegister(@RequestBody Ipo ipo ) {

        ipoService.save(ipo);
        response.setMessage("ipo registered successfully");
        return response;
    }

    @RequestMapping(value = "/ipo/findAll", method = RequestMethod.GET)
    public List<Ipo> findAll() {

        return ipoService.findAll();
    }

    @RequestMapping(value = "/findIpo/{userName}", method = RequestMethod.GET)
    public List<Ipo> findIpoByUserName(@PathVariable String userName) {
        logger.debug("username received to fetch Ipo is", userName);
        return ipoService.findIpoByUserName(userName);
    }

}

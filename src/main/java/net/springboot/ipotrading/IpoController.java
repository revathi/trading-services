package net.springboot.ipotrading;

import net.springboot.ipotrading.model.Ipo;
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



    private static final Logger logger = LoggerFactory.getLogger(IpoController.class);

    @RequestMapping(value = "/ipo/register", method = RequestMethod.POST)
    public String ipoRegister(@RequestBody Ipo ipo ) {

        logger.debug("Ipo received is", ipo.toString());
        ipoService.save(ipo);
        return "Registered for Ipo successfully";
    }

    @RequestMapping(value = "/ipo/findAll", method = RequestMethod.GET)
    public List<Ipo> findAll( ) {

        return ipoService.findAll();
    }


}

package net.springboot.ipotrading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import net.springboot.ipotrading.service.UserService;


import net.springboot.ipotrading.model.User;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;



    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestBody User user ) {

        logger.debug("user received is", user);
        userService.save(user);

        return "success";
    }

    @RequestMapping(value = "/getUser/{userName}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userName ) {

        logger.debug("username received is", userName);

        User user = userService.findByUserName(userName);
        logger.debug("user found is", user.getUserName().toString());

        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean    authenticateUser( @RequestBody User user ) {

        logger.debug("user received is", user.toString());

        User userfound = userService.findByUserName(user.getUserName());
        logger.debug("user found is", userfound);
        if(userfound!=null&& userfound.equals(user)){
         return   true;
        }

        return false ;
    }


}

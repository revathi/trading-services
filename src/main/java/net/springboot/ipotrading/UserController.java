package net.springboot.ipotrading;

import net.springboot.ipotrading.model.LoginResponse;
import net.springboot.ipotrading.model.PrimeResponse;
import org.graalvm.compiler.word.Word;
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
    @Autowired
    private PrimeResponse response;
    @Autowired
    private LoginResponse loginResponse;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public PrimeResponse registration(@RequestBody User user) {

        logger.debug("user received is", user);
        if (userService.findByUserName(user.getUserName()) == null) {
            userService.save(user);
            response.setMessage("User Registered Successfully");

        } else {
            response.setMessage("User already exists");
        }

        return response;
    }

    @RequestMapping(value = "/getUser/{userName}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userName) {

        logger.debug("username received is", userName);

        User user = userService.findByUserName(userName);
        logger.debug("user found is", user.getUserName());

        return user;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public LoginResponse authenticateUser(@RequestBody User user) {

        User userfound = userService.findByUserName(user.getUserName());
        logger.debug("user found is", userfound);
        if (userfound != null && userfound.equals(user) && userfound.getPassword().equals(user.getPassword())) {
            loginResponse.setMessage(true);
            loginResponse.setUserType(userfound.getUserType());
            loginResponse.setUserName(userfound.getUserName());
            return loginResponse;
        } else {
            loginResponse.setMessage(false);
            return loginResponse;
        }
    }


}

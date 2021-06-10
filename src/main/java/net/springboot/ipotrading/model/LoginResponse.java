package net.springboot.ipotrading.model;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse  {

    private String userName;
    private String userType;
    private Boolean message;

    public Boolean getMessage() {
        return message;
    }

    public void setMessage(Boolean message) {
        this.message = message;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}

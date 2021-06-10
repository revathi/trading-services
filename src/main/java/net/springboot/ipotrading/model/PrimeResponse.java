package net.springboot.ipotrading.model;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class PrimeResponse {

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeResponse response = (PrimeResponse) o;
        return message.equals(response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }



}

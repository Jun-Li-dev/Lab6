package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
public class HomeController {

    @PostMapping(path = "/say-hi-back", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String say_hi_back(@RequestParam(value = "data", defaultValue = "Enjoy your day!\n") String data) {
        return "Echo: " + data;
    }

    @PostMapping(path = "/email-address-valid", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String isEmailValid(@RequestParam(value = "email") String email) {
        String data = "";
        if (email.contains("@") && email.contains(".")) {
            data = "Valid email address.";
        } else {
            data = "Invalid email address.";
        }
        return "Email check: " + email + " is " + data + "\n";
    }

    @PostMapping(path = "/password-quality", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String checkPasswordQuality(@RequestParam(value = "password") String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) score++;

        String quality;
        if (score <= 2) quality = "Weak";
        else if (score == 3 || score == 4) quality = "Medium";
        else quality = "Strong";

        return "Password quality: " + quality + "\n";
    }
}

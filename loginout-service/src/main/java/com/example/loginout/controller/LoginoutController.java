package com.example.loginout.controller;

import com.example.loginout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginoutController {

    @Autowired
    private AccountService accountService;

    public String login(){

        return "0";
    }

    public String logout(){

        return "1";
    }
}

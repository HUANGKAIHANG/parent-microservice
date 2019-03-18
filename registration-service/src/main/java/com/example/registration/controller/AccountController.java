package com.example.registration.controller;

import com.example.registration.model.Account;
import com.example.registration.service.AccountService;
import com.example.registration.tools.CipherText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public String postAccount(@RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password,
                              @RequestParam(name = "type") String accountType,
                              Model model) {
        System.out.println("进入postAccount，参数打印");
        System.out.println(username + "--" + password + "--" + accountType);

        if (accountService.usernameExists(username)) {
            return "fail";
        } else {
            Account account = Account.builder().username(username)
                    .password(CipherText.getCipherText(password))
                    .accountType(accountService.getAccountType(accountType))
                    .build();
            accountService.saveAccount(account);
            return "success";
        }
    }
}

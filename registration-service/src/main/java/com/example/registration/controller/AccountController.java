package com.example.registration.controller;

import com.example.registration.model.Account;
import com.example.registration.service.AccountService;
import com.example.registration.tools.CipherText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v0")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public String createAccount(@RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password,
                              @RequestParam(name = "type") String accountType) {
        System.out.println("注册服务——进入postAccount，参数打印");
        System.out.println(username + "--" + password + "--" + accountType);

        //若用户名存在，不允许注册
        if (accountService.usernameExists(username)) {
            return "fail";
        } else {
            //用户名不存在，允许注册
            Account account = Account.builder().username(username)
                    .password(CipherText.getCipherText(password))
                    .accountType(accountService.getAccountType(accountType))
                    .build();
            Account simpleAccount = Account.builder().username(username).build();
            accountService.saveAccount(simpleAccount,account);
            return "success";
        }
    }
}

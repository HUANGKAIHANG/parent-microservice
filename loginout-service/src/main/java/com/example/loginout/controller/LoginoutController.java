package com.example.loginout.controller;

import com.example.loginout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1")
public class LoginoutController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        @RequestParam(name = "type") String accountType) {
        System.out.println("登录登出服务——进入login，参数打印");
        System.out.println(username + "--" + password + "--" + accountType);
        //检查用户名是否存在
        if (accountService.usernameExists(username)) {
            //检查密码是否正确
            if (accountService.validPassword(username, password)) {
                //密码正确，检查是卖家还是买家
                if ("1".equals(accountType)) {
                    return "buyer";
                } else if ("2".equals(accountType)) {
                    return "seller";
                }
            } else {
                //密码不正确
                return "wrong username or password";
            }
        }
        //用户名不存在
        return "username does not exist";
    }

    @GetMapping("/logout")
    public String logout() {
        System.out.println("登录登出服务——进入logout，参数打印");
        return "logout";
    }
}

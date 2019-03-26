package com.example.loginout.controller;

import com.example.loginout.model.Account;
import com.example.loginout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@RequestMapping(value = "v1")
public class LoginoutController {

    @Autowired
    private AccountService accountService;

    @PostMapping("v0/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        @RequestParam(name = "type") String accountType,
                        HttpSession session, HttpServletRequest request) {

        System.out.println("登录登出服务——进入login，参数打印");
        System.out.println(username + "--" + password + "--" + accountType);

        //检查用户名是否存在
        if (accountService.usernameExists(username)) {
            //检查密码和身份是否正确
            if (accountService.validAccount(username, password, accountType)) {
                //密码和身份正确
                if ("1".equals(accountType)) {
                    Long buyerId = accountService.getAccountId(username);
                    System.out.println("login session1:" + session.getId());
                    System.out.println(request.getSession().getId());
                    session.setAttribute(session.getId(), buyerId);
                    return String.valueOf(buyerId);
                } else if ("2".equals(accountType)) {
                    Long sellerId = accountService.getAccountId(username);
                    System.out.println("login session2:" + session.getId());
                    System.out.println(request.getSession().getId());
                    session.setAttribute(session.getId(), sellerId);
                    return String.valueOf(sellerId);
                }
            } else {
                //密码或身份不正确
                return "wrong username or password";
            }
        }
        //用户名不存在
        return "username does not exist";
    }

    @GetMapping("v0/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        System.out.println("登录登出服务——进入logout，参数打印");
        System.out.println("logout session:" + session.getId());
        System.out.println(request.getSession().getId());
        System.out.println(session.getAttribute(session.getId()));
        session.removeAttribute(session.getId());
        session.invalidate();
        return "logout";
    }

    @GetMapping("v1/account")
    public List<Account> getAllAccount(){
        System.out.println("登录登出服务——进入getAllAccount，参数打印");
        return accountService.getAllAccount();
    }

    @GetMapping("sid")
    public String getSid(HttpSession session) {
        return session.getId();
    }
}

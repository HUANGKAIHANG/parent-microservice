package com.example.adminloginout.controller;

import com.example.adminloginout.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "v0")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;

    @PostMapping("/adminlogin")
    public String adminLogin(@RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password,
                             HttpSession session, HttpServletRequest request) {
        System.out.println("管理员登录登出服务——进入adminLogin，参数打印");
        System.out.println(username + "--" + password);

        //验证
        if (adminAccountService.validAdminAccount(username, password)) {
            System.out.println("admin login session:" + session.getId());
            System.out.println(request.getSession().getId());
            session.setAttribute(session.getId(), "0");
            session.setAttribute("type", "administrator");
            return "administrator";
        }
        return "wrong admin username or password";
    }

    @GetMapping("/adminlogout")
    public String adminLogout(HttpSession session, HttpServletRequest request) {
        System.out.println("管理员登录登出服务——进入adminLogout，参数打印");
        System.out.println(request.getSession().getId());
        System.out.println(session.getAttribute(session.getId()));
        session.removeAttribute(session.getId());
        session.removeAttribute("type");
        session.invalidate();
        return "adminlogout";
    }

    @GetMapping("v0/validatelogin")
    public String validateLogin(HttpSession session) {
        System.out.println("管理员登录登出服务——进入validate,参数打印");
        System.out.println("validate session id" + session.getId());
        if (session.getAttribute(session.getId()) == null) {
            return "no";
        }
        return "admin";
    }
}

package com.example.adminloginout.controller;

import com.example.adminloginout.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v0")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;

    @PostMapping("/adminlogin")
    public String adminLogin(@RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password) {
        System.out.println("管理员登录登出服务——进入adminLogin，参数打印");
        System.out.println(username + "--" + password);

        //验证
        if (adminAccountService.validAdminAccount(username, password)) {
            return "administrator";
        }
        return "wrong admin username or password";
    }

    @GetMapping("/adminlogout")
    public String adminLogout() {
        System.out.println("管理员登录登出服务——进入adminLogout，参数打印");
        return "adminlogout";
    }
}

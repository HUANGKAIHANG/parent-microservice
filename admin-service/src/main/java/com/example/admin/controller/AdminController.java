package com.example.admin.controller;

import com.example.admin.model.Account;
import com.example.admin.model.Commodity;
import com.example.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/account")
    public List<Account> getAllAccount(){
        System.out.println("管理员服务——进入getAllAccount，参数打印");
        return adminService.retrieveAllAccount();
    }

    @GetMapping("/commodity")
    public List<Commodity> getAllCommodity(){
        System.out.println("管理员服务——进入getAllCommodity，参数打印");
        return adminService.retrieveAllCommodity();
    }
}

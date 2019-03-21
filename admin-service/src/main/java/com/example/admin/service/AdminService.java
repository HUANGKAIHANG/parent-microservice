package com.example.admin.service;

import com.example.admin.client.AccountFeignClient;
import com.example.admin.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    public List<Account> retrieveAllAccount(){
        System.out.println("正在使用accountFeignClient。。。");
        return accountFeignClient.getAllAccount();
    }
}

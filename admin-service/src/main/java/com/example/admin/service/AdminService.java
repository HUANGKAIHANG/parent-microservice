package com.example.admin.service;

import com.example.admin.client.AccountFeignClient;
import com.example.admin.client.CommodityFeignClient;
import com.example.admin.model.Account;
import com.example.admin.model.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private CommodityFeignClient commodityFeignClient;

    public List<Account> retrieveAllAccount() {
        System.out.println("正在使用accountFeignClient。。。");
        return accountFeignClient.getAllAccount();
    }

    public List<Commodity> retrieveAllCommodity() {
        System.out.println("正在使用commodityFeignClient。。。");
        return commodityFeignClient.getAllCommodity();
    }
}

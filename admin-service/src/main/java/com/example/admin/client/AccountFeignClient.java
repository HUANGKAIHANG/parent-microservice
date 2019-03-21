package com.example.admin.client;

import com.example.admin.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loginoutservice")
public interface AccountFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/account",
            consumes = "application/json")
    List<Account> getAllAccount();
}

package com.example.admin.client;

import com.example.admin.model.Commodity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("commodityservice")
public interface CommodityFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "v0/commodity",
            consumes = "application/json")
    List<Commodity> getAllCommodity();
}

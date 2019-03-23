package com.example.cart.client;

import com.example.cart.model.Commodity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("commodityservice")
public interface CommodityFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/commodity/{commodityId}",
            consumes = "application/json")
    Commodity getCommodityById(@PathVariable("commodityId") Long commodityId);
}

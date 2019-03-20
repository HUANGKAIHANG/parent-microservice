package com.example.commodity.service;

import com.example.commodity.model.Commodity;
import com.example.commodity.model.Sell;
import com.example.commodity.repository.CommodityRepository;
import com.example.commodity.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private SellRepository sellRepository;

    public void createCommodity(Commodity commodity, Long accountId) {
        Commodity c = commodityRepository.save(commodity);
        System.out.println("数据库返回的commodity ID为" + c.getId());
        Sell sell = Sell.builder().accountId(accountId)
                .commodityId(c.getId()).build();
        sellRepository.save(sell);
    }

    public Commodity getCommodity(Long id) {
        return commodityRepository.findByIdAndVisible(id, 1);
    }

    public List<Commodity> getAllCommodity() {
        return commodityRepository.findAllByVisible(1);
    }

    public void updateCommodity(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    public List<Long> getMyCommodityId(Long accountId) {
        List<Sell> sells = sellRepository.findAllByAccountId(accountId);
        List<Long> commodityIds = new ArrayList<>();
        for (Sell s : sells) {
            commodityIds.add(s.getCommodityId());
        }
        return commodityIds;
    }

    public List<Commodity> getMyCommodity(List<Long> id) {
        return commodityRepository.findAllByVisibleAndIdIn(1, id);
    }
}

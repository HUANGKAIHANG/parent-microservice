package com.example.commodity.repository;

import com.example.commodity.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellRepository extends JpaRepository<Sell,Long> {

    List<Sell> findAllByAccountId(Long accountId);
}

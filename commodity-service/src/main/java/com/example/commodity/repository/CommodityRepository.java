package com.example.commodity.repository;

import com.example.commodity.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {

    Commodity findByIdAndVisible(Long id, int visible);

    List<Commodity> findAllByVisible(int visible);

    List<Commodity> findAllByVisibleAndIdIn(int visible, List<Long> id);
}

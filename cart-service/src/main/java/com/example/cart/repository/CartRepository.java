package com.example.cart.repository;

import com.example.cart.model.Cart;
import com.example.cart.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Modifying
    @Transactional
    @Query(value = "update cart set quantity=?1 where id = ?2", nativeQuery = true)
    void setQuantityById(int quantity, Long id);

    @Modifying
    @Transactional
    @Query(value = "update cart set status=?1 where order_id = ?2", nativeQuery = true)
    void setPaidStatusByOrderId(String status, String orderId);

    @Modifying
    @Transactional
    @Query(value = "update cart set entry_price=?1 where id = ?2", nativeQuery = true)
    void setEntryPriceByOrderId(BigDecimal entryPrice, Long id);

    List<Cart> findAllByAccountIdAndStatus(Long accountId, Status status);

    Cart findByAccountIdAndStatus(Long accountId, Status status);
}

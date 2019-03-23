package com.example.cart.service;

import com.example.cart.client.CommodityFeignClient;
import com.example.cart.model.Cart;
import com.example.cart.model.Commodity;
import com.example.cart.model.Status;
import com.example.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CommodityFeignClient commodityFeignClient;

    public void addACart(Cart cart) {
        Commodity commodity = commodityFeignClient.getCommodityById(cart.getCommodityId());
        cart.setEntryPrice(commodity.getPrice().multiply(new BigDecimal(cart.getQuantity())));
        cartRepository.save(cart);
    }

    public void deleteACart(Long id) {
        cartRepository.delete(id);
    }

    public void changeQuantityById(Long id, int quantity) {
        cartRepository.setQuantityById(quantity, id);
        BigDecimal price = commodityFeignClient.getCommodityById(this.getACart(id).getCommodityId()).getPrice();
        cartRepository.setEntryPriceByOrderId(price.multiply(new BigDecimal(quantity)), id);
    }

    public void changeStatusByOrderId(String orderId) {
        cartRepository.setPaidStatusByOrderId("PAID", orderId);
    }

    public List<Cart> getMyCart(Long accountId) {
        List<Cart> carts = cartRepository.findAllByAccountIdAndStatus(accountId, Status.CART);
        for (Cart cart : carts)
            cart.setName(commodityFeignClient.getCommodityById(cart.getCommodityId()).getName());
        return carts;
    }

    public String getMyCurrentOrderId(Long accountId) {
        return cartRepository.findByAccountIdAndStatus(accountId, Status.CART).getOrderId();
    }

    public BigDecimal getTotalPrice(List<Cart> carts) {
        BigDecimal total = new BigDecimal(0);
        for (Cart cart : carts) {
            total = total.add(cart.getEntryPrice());
        }
        return total;
    }

    public Cart getACart(Long id) {
        return cartRepository.findOne(id);
    }
}

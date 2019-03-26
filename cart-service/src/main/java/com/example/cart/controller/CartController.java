package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Status;
import com.example.cart.service.CartService;
import com.example.cart.tools.NewUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public String addACart(@RequestParam(name = "commodityId") Long commodityId, HttpSession session) {

        Long accountId = (Long) session.getAttribute(session.getId());

        System.out.println("购物车服务——进入addACart，参数打印");
        System.out.println("accountId="+accountId + "--" + commodityId);

        Cart cart = Cart.builder().accountId(accountId).commodityId(commodityId)
                .quantity(1).status(Status.CART).build();
        if (cartService.getMyCart(accountId).size() == 0)
            cart.setOrderId(NewUUID.get());
        else
            cart.setOrderId(cartService.getMyCurrentOrderId(accountId));
        cartService.addACart(cart);
        return "success";
    }

    @DeleteMapping("/cart/{id}")
    public String deleteACart(@PathVariable(name = "id") Long id) {
        System.out.println("购物车服务——进入deleteACart，参数打印");
        System.out.println(id);

        cartService.deleteACart(id);
        return "success";
    }

    @PutMapping("/cart/{id}/{quantity}")
    public String changeQuantityById(@PathVariable(name = "id") Long id,
                                     @PathVariable(name = "quantity") int quantity) {

        System.out.println("购物车服务——进入changeQuantityById，参数打印");
        System.out.println(id + "--" + quantity);

        cartService.changeQuantityById(id, quantity);
        return "success";
    }

    @PutMapping("/cart/{orderId}")
    public String changeStatusByOrderId(@PathVariable(name = "orderId") String orderId) {

        System.out.println("购物车服务——进入changeStatusByOrderId，参数打印");
        System.out.println(orderId);

        cartService.changeStatusByOrderId(orderId);
        return "success";
    }

    @GetMapping("/cart")
    public List<Cart> getMyCart(HttpSession session) {

        Long accountId = (Long) session.getAttribute(session.getId());

        System.out.println("购物车服务——进入getMyCart，参数打印");
        System.out.println("accountId="+accountId);

        return cartService.getMyCart(accountId);
    }

    @GetMapping("/cart/totalprice")
    public BigDecimal getTotalPrice(HttpSession session) {

        Long accountId = (Long) session.getAttribute(session.getId());

        System.out.println("购物车服务——进入getTotalPrice，参数打印");
        System.out.println("accountId="+accountId);

        return cartService.getTotalPrice(cartService.getMyCart(accountId));
    }


}

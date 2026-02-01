package com.genie.Ecomm.controller;

import com.genie.Ecomm.model.CartItem;
import com.genie.Ecomm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }

    @DeleteMapping("/remove")
    public void removeFromCart(@RequestParam Long userId, @RequestParam Long productId) {
        cartService.removeFromCart(userId, productId);
    }
}

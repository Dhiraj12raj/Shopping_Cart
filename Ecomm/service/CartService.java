package com.genie.Ecomm.service;

import com.genie.Ecomm.model.CartItem;
import com.genie.Ecomm.model.Product;
import com.genie.Ecomm.repo.CartItemRepository;
import com.genie.Ecomm.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    public CartItem addToCart(Long userId, Long productId, int quantity) {
        Product product = productRepo.findById(productId).orElseThrow();
        CartItem item = new CartItem();
        item.setUserId(userId);
        item.setProduct(product);
        item.setQuantity(quantity);
        return cartRepo.save(item);
    }

    public List<CartItem> getCartItems(Long userId) {
        return cartRepo.findByUserId(userId);
    }

    public void removeFromCart(Long userId, Long productId) {
        cartRepo.deleteByUserIdAndProductId(userId, productId);
    }
}

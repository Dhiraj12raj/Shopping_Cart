package com.genie.Ecomm.model;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Or reference to User if you have User entity

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public void setUserId(Long userId) {
    }

    public void setQuantity(int quantity) {
    }

    public void setProduct(Product product) {
    }

    // Getters and setters
}

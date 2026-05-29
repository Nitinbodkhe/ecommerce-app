package com.ecommerce.backend.service;

import com.ecommerce.backend.entity.Cart;
import com.ecommerce.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Add product to cart
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Get all cart items of a user
    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    // Remove cart item
    public void removeCartItem(Long id) {
        cartRepository.deleteById(id);
    }
}
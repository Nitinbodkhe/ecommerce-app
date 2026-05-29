package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.Wishlist;
import com.ecommerce.backend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;

    // Add to Wishlist
    @PostMapping
    public Wishlist addToWishlist(@RequestBody Wishlist wishlist) {

        return wishlistRepository.save(wishlist);
    }

    // Get Wishlist Items
    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistItems(@PathVariable Long userId) {

        return wishlistRepository.findByUserId(userId);
    }

    // Remove Wishlist Item
    @DeleteMapping("/{id}")
    public String removeWishlistItem(@PathVariable Long id) {

        wishlistRepository.deleteById(id);

        return "Wishlist item removed successfully";
    }
}
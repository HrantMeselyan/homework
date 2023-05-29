package com.example.shoppingapphomework.service.cartImpl;

import com.example.shoppingapphomework.entity.Cart;
import com.example.shoppingapphomework.entity.Product;
import com.example.shoppingapphomework.entity.User;
import com.example.shoppingapphomework.security.CurrentUser;

import java.util.List;

public interface CartService {
    void save(int productId, CurrentUser currentUser);

    List<Cart> getAllById(User user);

}


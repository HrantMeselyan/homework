package com.example.shoppingapphomework.service.OrderImpl;

import com.example.shoppingapphomework.security.CurrentUser;

import java.util.List;

public interface OrderService {
    void order(CurrentUser currentUser, List<Integer> productIds);
}

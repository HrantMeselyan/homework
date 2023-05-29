package com.example.shoppingapphomework.service.impl;

import com.example.shoppingapphomework.entity.Order;
import com.example.shoppingapphomework.entity.Product;
import com.example.shoppingapphomework.repository.CartRepository;
import com.example.shoppingapphomework.repository.OrderRepository;
import com.example.shoppingapphomework.repository.ProductRepository;
import com.example.shoppingapphomework.security.CurrentUser;
import com.example.shoppingapphomework.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public void order(CurrentUser currentUser, List<Integer> productIds) {
        Order order = new Order();
        order.setDateTime(LocalDateTime.now());
        order.setUser(currentUser.getUser());
        List<Product> productList = new ArrayList<>();
        for (Integer productId : productIds) {
            Optional<Product> byId = productRepository.findById(productId);
            Product product = byId.get();
            productList.add(product);
        }
        order.setProductList(productList);
        orderRepository.save(order);
        int userId = currentUser.getUser().getId();
        cartRepository.deleteByUserId(userId);
    }
}

package com.example.shoppingapphomework.repository;

import com.example.shoppingapphomework.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

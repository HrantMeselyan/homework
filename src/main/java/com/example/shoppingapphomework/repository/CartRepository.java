package com.example.shoppingapphomework.repository;

import com.example.shoppingapphomework.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> getAllByUser_Id(int id);

    void deleteByUserId(int userId);

}


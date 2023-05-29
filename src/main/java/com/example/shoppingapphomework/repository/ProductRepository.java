package com.example.shoppingapphomework.repository;

import com.example.shoppingapphomework.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

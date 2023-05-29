package com.example.shoppingapphomework.repository;

import com.example.shoppingapphomework.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

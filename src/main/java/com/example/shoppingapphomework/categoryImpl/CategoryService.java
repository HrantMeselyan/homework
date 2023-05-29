package com.example.shoppingapphomework.categoryImpl;

import com.example.shoppingapphomework.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
}

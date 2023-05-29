package com.example.shoppingapphomework.categoryImpl;

import com.example.shoppingapphomework.entity.Category;
import com.example.shoppingapphomework.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }
}

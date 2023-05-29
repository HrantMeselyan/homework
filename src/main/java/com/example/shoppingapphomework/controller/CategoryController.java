package com.example.shoppingapphomework.controller;

import com.example.shoppingapphomework.categoryImpl.CategoryService;
import com.example.shoppingapphomework.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/";
    }


    @GetMapping("/add")
    public String addProductPage() {
        return "addCategory";
    }
}

package com.example.shoppingapphomework.controller;

import com.example.shoppingapphomework.entity.Product;
import com.example.shoppingapphomework.categoryImpl.CategoryService;
import com.example.shoppingapphomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, @RequestParam("img_path") MultipartFile multipartFile) throws IOException {
        productService.save(product, multipartFile);
        return "redirect:/";
    }


    @GetMapping("/add")
    public String addProductPage(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.findAll());
        return "addProduct";
    }
}

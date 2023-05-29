package com.example.shoppingapphomework.service;

import com.example.shoppingapphomework.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product, MultipartFile multipartFile) throws IOException;
}

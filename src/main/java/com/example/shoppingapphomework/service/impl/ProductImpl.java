package com.example.shoppingapphomework.service.impl;

import com.example.shoppingapphomework.entity.Product;
import com.example.shoppingapphomework.repository.ProductRepository;
import com.example.shoppingapphomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductImpl implements ProductService {
    private final ProductRepository productRepository;

   @Value("${shopping-app-homework.upload.image.path}")
   private String imageUploadPath;

    @Override
    public List<Product> findAll() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    @Override
    public void save(Product product, MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            product.setImgPath(fileName);
        }
        productRepository.save(product);
    }
}

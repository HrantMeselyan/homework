package com.example.shoppingapphomework.service.cartImpl;

import com.example.shoppingapphomework.entity.Cart;
import com.example.shoppingapphomework.entity.Product;
import com.example.shoppingapphomework.entity.User;
import com.example.shoppingapphomework.repository.CartRepository;
import com.example.shoppingapphomework.repository.ProductRepository;
import com.example.shoppingapphomework.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public void save(int productId, CurrentUser currentUser) {
        Cart cart = new Cart();
        cart.setUser(currentUser.getUser());
        List<Product> allById = productRepository.findAllById(Collections.singleton(productId));
        cart.setProductList(allById);
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllById(User user) {
        List<Cart> allByUserId = cartRepository.getAllByUser_Id(user.getId());
        return allByUserId;
    }
}

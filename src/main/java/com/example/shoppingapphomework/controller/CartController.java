package com.example.shoppingapphomework.controller;

import com.example.shoppingapphomework.security.CurrentUser;
import com.example.shoppingapphomework.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public String cartPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("carts", cartService.getAllById(currentUser.getUser()));
        return "cartPage";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") int productId, @AuthenticationPrincipal CurrentUser currentUser) {
        cartService.save(productId, currentUser);
        return "redirect:/";
    }
}

package com.example.shoppingapphomework.controller;

import com.example.shoppingapphomework.security.CurrentUser;
import com.example.shoppingapphomework.service.OrderImpl.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    private String addOrder(@AuthenticationPrincipal CurrentUser currentUser, @RequestParam("productId") List<Integer> productIds) {
       orderService.order(currentUser,productIds);
       return "redirect:/cart";
    }
}

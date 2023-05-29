package com.example.shoppingapphomework.controller;

import com.example.shoppingapphomework.entity.User;
import com.example.shoppingapphomework.entity.UserType;
import com.example.shoppingapphomework.service.mainImpl.MainService;
import com.example.shoppingapphomework.security.CurrentUser;
import com.example.shoppingapphomework.service.productImpl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    private final ProductService productService;


    @GetMapping("/")
    private String main(ModelMap modelMap) {
        modelMap.addAttribute("products",productService.findAll());
        return "index";
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("imgPath") String imageName) throws IOException {
        return mainService.getImage(imageName);
    }

    @GetMapping("/customLogin")
    public String customLogin() {
        return "customLoginPage";
    }

    @GetMapping("/customSuccessLogin")
    public String customSuccessLogin(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            if (user.getUserType() == UserType.ADMIN) {
                return "redirect:/user/admin";
            } else if (user.getUserType() == UserType.USER) {
                return "redirect:/";
            }
        }
        return "redirect:/";
    }
}

package com.example.shoppingapphomework.controller;



import com.example.shoppingapphomework.entity.User;
import com.example.shoppingapphomework.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CurrentUserControllerAdvice {

    @ModelAttribute("currentUser")
    public User curretnUser(@AuthenticationPrincipal CurrentUser currentUser){
        if(currentUser != null){
            return currentUser.getUser();
        }
        return null;
    }
}
package com.example.shoppingapphomework.service;


import com.example.shoppingapphomework.entity.User;

public interface UserService {
    User createUser(User User);

    void saveUser(User user);
}


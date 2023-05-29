package com.example.shoppingapphomework.service.UserImpl;


import com.example.shoppingapphomework.entity.User;
import com.example.shoppingapphomework.entity.UserType;
import com.example.shoppingapphomework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb.isEmpty()) {
            String password = user.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            user.setUserType(UserType.USER);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

}

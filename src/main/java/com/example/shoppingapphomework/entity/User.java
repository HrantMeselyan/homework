package com.example.shoppingapphomework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
}

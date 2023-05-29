package com.example.shoppingapphomework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    private int id;
    private String name;

}

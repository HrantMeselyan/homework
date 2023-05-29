package com.example.shoppingapphomework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;
    private String title;
    private int price;
    private String description;
    private String imgPath;
    @ManyToOne
    private Category category;
}

package com.etiya.training.entities;

import jakarta.persistence.*;

@Table(name="categories")
@Entity
public class Category {
    @Column(name="category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @Column(name="picture")
    private byte[] picture;
}

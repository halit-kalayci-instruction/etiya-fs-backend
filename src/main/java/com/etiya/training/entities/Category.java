package com.etiya.training.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="categories")
@Entity
@Data // getter-setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Column(name="category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @Column(name="picture")
    private byte[] picture;
}

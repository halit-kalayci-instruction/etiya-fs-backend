package com.etiya.training.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="products")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Column(name="product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @Column(name="discontinued")
    private int discontinued;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList;
}

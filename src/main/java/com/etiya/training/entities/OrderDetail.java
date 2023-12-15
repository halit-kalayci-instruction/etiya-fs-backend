package com.etiya.training.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="order_details")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // int => primitive type
    // Integer => Reference type

    @Column(name="unit_price")
    private Float unitPrice;

    @Column(name="quantity")
    private Short quantity;

    @Column(name="discount")
    private Float discount;


    // FK'nın olduğu tablo @ManyToOne
    // @JoinColumn() => Foreign Key hangi column?
    @ManyToOne()
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private Product product;
}

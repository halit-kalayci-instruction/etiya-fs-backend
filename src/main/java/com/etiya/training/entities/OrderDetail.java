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
    private int id;

    @Column(name="unit_price")
    private Float unitPrice;

    @Column(name="quantity")
    private Short quantity;

    @Column(name="discount")
    private Float discount;
}

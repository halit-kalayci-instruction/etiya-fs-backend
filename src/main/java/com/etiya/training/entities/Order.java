package com.etiya.training.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Column(name="order_id")
    @Id
    private Short orderId;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="required_date")
    private LocalDate requiredDate;

    @Column(name="shipped_date")
    private LocalDate shippedDate;

    @Column(name="freight")
    private Float freight;

    @Column(name="ship_name")
    private String shipName;

    @Column(name="ship_address")
    private String shipAddress;

    @Column(name="ship_city")
    private String shipCity;

    @Column(name="ship_region")
    private String shipRegion;

    @Column(name="ship_postal_code")
    private String shipPostalCode;

    @Column(name="ship_country")
    private String shipCountry;
}

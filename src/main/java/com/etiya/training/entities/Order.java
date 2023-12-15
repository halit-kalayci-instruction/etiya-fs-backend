package com.etiya.training.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    // FK'nın referans verdiği tabloda ise
    // @OneToMany(mappedBy="") FK'nın bulunduğu tablodaki
    // konfigürasyonun yapıldığı değişken adı
    @OneToMany(mappedBy = "order") // değişken ismi
    private List<OrderDetail> orderDetailList;
}

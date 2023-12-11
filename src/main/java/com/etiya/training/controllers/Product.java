package com.etiya.training.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // => getter-setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
    // encapsulation
    // alanlara direkt erişimin kısıtlanması
    // private => sadece class içi erişilebilir..
    private int id;
    // final =>  ilgili değişken, yalnızca ctorlar içerisinden değiştirilebilir.
    private String name;
    // ctor, constructor
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }
}


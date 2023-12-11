package com.etiya.training.controllers;

import lombok.Data;

@Data // => getter-setter
public class Product {
    // encapsulation
    // alanlara direkt erişimin kısıtlanması

    // private => sadece class içi erişilebilir..
    private int id;
    private String name;

    // getter-setter
}

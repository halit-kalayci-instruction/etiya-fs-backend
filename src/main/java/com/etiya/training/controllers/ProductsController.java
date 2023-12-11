package com.etiya.training.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/products")  // localhost:8080/api/products
public class ProductsController {

    // localhost:8080/api/products GET
    @GetMapping
    public String hello() {
        return "Merhaba";
    }
    // 11:05
}

package com.etiya.training.controllers;
import com.etiya.training.entities.Product;
import com.etiya.training.repositories.ProductRepository;
import com.etiya.training.services.abstracts.ProductService;
import com.etiya.training.services.concretes.ProductManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/products")  // localhost:8080/api/products
public class ProductsController {

    // spring tarafından auto
    // DI her zaman soyut olmalı!
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/api/products GET
    // localhost:8080/api/products?a=Halit GET
    @GetMapping
    public List<Product> getAll(){
        return null; // Select * from products
    }

    // HTTP Method değiştirmek
    // URL'i değiştirmek
    // Parametre yapısını değiştirmek
    // localhost:8080/api/products/get2 GET
    @GetMapping("{id}") // { değişken }
    public Product getById(@PathVariable Short id) {
        return null;
    }

    @PostMapping
    public Product add(@RequestBody Product product)
    {
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Short id) {

    }

    @PutMapping
    public String update(@RequestBody Product product) {
        // Save methodu ilgili entitynin idsi var ise güncelleme, yok ise ekleme yapar.
        return "Put mapping çalışıyor..";
    }


}


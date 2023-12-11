package com.etiya.training.controllers;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/products")  // localhost:8080/api/products
public class ProductsController {

    // localhost:8080/api/products GET
    // localhost:8080/api/products?a=Halit GET
    @GetMapping
    public String hello(@RequestParam("a") String name) {
        return "Merhaba " + name;
    }

    // HTTP Method değiştirmek
    // URL'i değiştirmek
    // Parametre yapısını değiştirmek
    // localhost:8080/api/products/get2 GET
    @GetMapping("{name}") // { değişken }
    public String hello2(@PathVariable String name) {
        return "Merhaba 2 " + name;
    }

    @PostMapping
    public String postMapping(@RequestBody Product product)
    {
        return "Eklenen ürün idsi: " + product.id + " name'i: " + product.name;
    }

    @PutMapping
    public String putMapping() {
        return "Put mapping çalışıyor..";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "Delete mapping çalışıyor";
    }
}


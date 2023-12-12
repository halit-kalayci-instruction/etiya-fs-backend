package com.etiya.training.controllers;
import com.etiya.training.entities.Product;
import com.etiya.training.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/products")  // localhost:8080/api/products
public class ProductsController {

    // spring tarafından auto
    private final ProductRepository productRepository;
    public ProductsController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }



    // localhost:8080/api/products GET
    // localhost:8080/api/products?a=Halit GET
    @GetMapping
    public List<Product> getAll(){
        return this.productRepository.findAll(); // Select * from products
    }

    // HTTP Method değiştirmek
    // URL'i değiştirmek
    // Parametre yapısını değiştirmek
    // localhost:8080/api/products/get2 GET
    @GetMapping("{id}") // { değişken }
    public Product getById(@PathVariable Short id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public String postMapping()
    {
        return "Post mapping çalışıyor";
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


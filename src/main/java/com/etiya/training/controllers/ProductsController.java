package com.etiya.training.controllers;
import com.etiya.training.entities.Product;
import com.etiya.training.services.abstracts.ProductService;
import com.etiya.training.services.dtos.product.AddProductRequest;
import com.etiya.training.services.dtos.product.GetListProductResponse;
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
    public List<GetListProductResponse> getAll(){
        return productService.getAll(); // Select * from products
    }

    // HTTP Method değiştirmek
    // URL'i değiştirmek
    // Parametre yapısını değiştirmek
    // localhost:8080/api/products/get2 GET
    @GetMapping("{id}") // { değişken }
    public Product getById(@PathVariable Short id) {
        return null;
    }

    @GetMapping("search")
    public List<GetListProductResponse> search(@RequestParam String name)
    {
        return productService.search(name);
    }
    @PostMapping
    public Product add(@RequestBody AddProductRequest product)
    {
        return productService.add(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Short id) {
        productService.delete(id);
    }

    @PutMapping
    public String update(@RequestBody Product product) {
        // Save methodu ilgili entitynin idsi var ise güncelleme, yok ise ekleme yapar.
        return "Put mapping çalışıyor..";
    }


}


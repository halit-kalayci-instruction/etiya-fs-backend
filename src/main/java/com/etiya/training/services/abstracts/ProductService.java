package com.etiya.training.services.abstracts;

import com.etiya.training.entities.Product;

public interface ProductService
{
    Product add(Product product);
    void delete(Short id);
}

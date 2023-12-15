package com.etiya.training.services.abstracts;

import com.etiya.training.entities.Product;
import com.etiya.training.services.dtos.product.AddProductRequest;
import com.etiya.training.services.dtos.product.GetListProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService
{
    Product add(AddProductRequest request);
    void delete(Short id);
    Product update();
    List<GetListProductResponse> getAll();
    List<GetListProductResponse> search(String name);
    Optional<Product> getById(Short id);
}

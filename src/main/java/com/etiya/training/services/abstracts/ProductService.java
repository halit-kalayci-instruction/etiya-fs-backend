package com.etiya.training.services.abstracts;

import com.etiya.training.entities.Product;
import com.etiya.training.services.dtos.product.AddProductRequest;
import com.etiya.training.services.dtos.product.GetListProductResponse;

import java.util.List;

public interface ProductService
{
    Product add(AddProductRequest request);
    void delete(Short id);
    List<GetListProductResponse> getAll();
    List<GetListProductResponse> search(String name);
}

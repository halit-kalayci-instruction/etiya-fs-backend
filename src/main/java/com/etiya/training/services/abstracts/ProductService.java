package com.etiya.training.services.abstracts;

import com.etiya.training.entities.Product;
import com.etiya.training.services.dtos.product.ProductForAddDto;

public interface ProductService
{
    Product add(ProductForAddDto request);
    void delete(Short id);
}

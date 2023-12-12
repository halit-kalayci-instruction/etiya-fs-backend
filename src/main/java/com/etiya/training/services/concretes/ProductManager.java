package com.etiya.training.services.concretes;

import com.etiya.training.entities.Product;
import com.etiya.training.services.abstracts.ProductService;
import org.springframework.stereotype.Service;

// interface-interface => extends
// class-class => extends
// class-interface => implements
@Service
public class ProductManager implements ProductService
{
    @Override
    public Product add(Product product) {
        // ekleme işi için iş akışı
        return null;
    }

    @Override
    public void delete(Short id)
    {

    }
}

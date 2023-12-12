package com.etiya.training.services.concretes;

import com.etiya.training.entities.Category;
import com.etiya.training.entities.Product;
import com.etiya.training.repositories.ProductRepository;
import com.etiya.training.services.abstracts.ProductService;
import com.etiya.training.services.dtos.product.ProductForAddDto;
import org.springframework.stereotype.Service;

// interface-interface => extends
// class-class => extends
// class-interface => implements
@Service
public class ProductManager implements ProductService
{
    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(ProductForAddDto request) {
        // ekleme işi için iş akışı
        // dTo => Transfer => Mapping

        // Manual Mapping
        Product newProduct = new Product();
        newProduct.setProductName(request.getProductName());
        newProduct.setQuantityPerUnit(request.getQuantityPerUnit());
        newProduct.setDiscontinued(request.getDiscontinued());

        // TODO: Kategori veritabanından kullanıcının verdiği id ile bi kayıt varsa onu kullan yoksa hata ver.
        Category category = new Category();
        category.setCategoryId(request.getCategoryId());

        newProduct.setCategory(category);

        return this.productRepository.save(newProduct);
    }

    @Override
    public void delete(Short id)
    {

    }
}

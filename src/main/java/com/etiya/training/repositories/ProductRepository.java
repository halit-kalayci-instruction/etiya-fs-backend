package com.etiya.training.repositories;

// JpaRepository => extends

import com.etiya.training.entities.Product;
import com.etiya.training.services.dtos.product.GetListProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Short>
{
    // JPQL'de tablo ismi değil Entity ismi ile kullanılır. * yerine Alias kullanılır.
    //@Query(value = "Select * from products p", nativeQuery = true)
    @Query(value = "Select p from Product p Where p.discontinued=0", nativeQuery = false)
    List<Product> findAllCustom();


    // String => Kod bloğu
    // classın tam yolu

    // JpaBase.Java
    @Query("Select new com.etiya.training.services.dtos.product.GetListProductResponse(p.productId, p.productName) from Product p")
    List<GetListProductResponse> getAll();
}

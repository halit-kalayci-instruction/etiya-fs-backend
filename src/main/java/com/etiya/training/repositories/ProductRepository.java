package com.etiya.training.repositories;

// JpaRepository => extends

import com.etiya.training.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Short>
{
}

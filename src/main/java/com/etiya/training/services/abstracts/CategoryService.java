package com.etiya.training.services.abstracts;

import com.etiya.training.entities.Category;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> getById(Short id);
}

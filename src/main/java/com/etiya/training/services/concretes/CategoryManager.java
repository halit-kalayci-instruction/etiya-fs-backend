package com.etiya.training.services.concretes;

import com.etiya.training.entities.Category;
import com.etiya.training.repositories.CategoryRepository;
import com.etiya.training.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getById(Short id) {
        return categoryRepository.findById(id);
    }
}

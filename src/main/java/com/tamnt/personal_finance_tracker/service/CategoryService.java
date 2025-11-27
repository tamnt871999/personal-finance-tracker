package com.tamnt.personal_finance_tracker.service;

import com.tamnt.personal_finance_tracker.model.Category;
import com.tamnt.personal_finance_tracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    public List<Category> findAllCategories() {
        
        return categoryRepository.findAll();
    }
}

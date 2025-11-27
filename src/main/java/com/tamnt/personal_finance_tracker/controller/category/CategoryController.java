package com.tamnt.personal_finance_tracker.controller.category;

import com.tamnt.personal_finance_tracker.model.Category;
import com.tamnt.personal_finance_tracker.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {

        List<Category> categories = categoryService.findAllCategories();

        return ResponseEntity.ok(categories);
    }
}

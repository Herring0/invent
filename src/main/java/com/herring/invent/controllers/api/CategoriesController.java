package com.herring.invent.controllers.api;

import com.herring.invent.models.Category;
import com.herring.invent.payload.response.ErrorResponse;
import com.herring.invent.repository.CategoriesRepository;
import com.herring.invent.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping("/list")
    public ResponseEntity<?> categoriesList() {
        return ResponseEntity.ok(categoriesService.getAllCategories());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> categoryById(@PathVariable("id") int id) {
        Category category = categoriesService.getCategoryById(id);
        if (category == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Category not found"));
        else
            return ResponseEntity.ok(category);
    }

}

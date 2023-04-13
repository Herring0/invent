package com.herring.invent.controllers.api;

import com.herring.invent.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/list")
    public ResponseEntity<?> categoriesList() {
        return ResponseEntity.ok(categoriesService.getAllCategories());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> categoryById(@PathVariable("id") int id) {
        return ResponseEntity.ok(categoriesService.getCategoryById(id));
    }

}

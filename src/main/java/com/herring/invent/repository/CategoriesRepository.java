package com.herring.invent.repository;

import com.herring.invent.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface CategoriesRepository extends JpaRepository<Category, Integer> {
    Optional<Category> getCategoryByName(String name);
}
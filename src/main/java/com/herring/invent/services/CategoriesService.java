package com.herring.invent.services;

import com.herring.invent.models.Category;
import com.herring.invent.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Category> getAllCategories() {
        return getTree(categoriesRepository.findAll());
    }

    public Category getCategoryById(int id) {
        return getTree(categoriesRepository.findAll(), id);
    }

    public Optional<Category> getCategoryByName(String name) {
        return categoriesRepository.getCategoryByName(name);
    }

    private List<Category> getTree(List<Category> dataset) {
        Iterator<Category> itr = dataset.iterator();

        while (itr.hasNext()) {
            Category cat = itr.next();
            if (cat.getParent() != null) {
                cat.getParent().addChildren(cat);
                itr.remove();
            }
        }

        return dataset;
    }

    private Category getTree(List<Category> dataset, int id) {
        Iterator<Category> itr = dataset.iterator();
        Category target = null;

        while (itr.hasNext()) {
            Category cat = itr.next();
            if (cat.getParent() != null) {
                cat.getParent().addChildren(cat);
                itr.remove();
            }
            if (cat.getId() == id) {
                target = cat;
            }
        }

        return target;
    }

}

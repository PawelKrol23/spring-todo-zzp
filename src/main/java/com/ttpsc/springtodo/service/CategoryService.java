package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.Category;
import com.ttpsc.springtodo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Category> getCategories(Long userId){
        return categoryRepository.getUsersCategories(userId);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoriesByName(name);
    }
}

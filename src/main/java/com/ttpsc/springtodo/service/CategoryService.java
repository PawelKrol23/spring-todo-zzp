package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.Category;
import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.repository.CategoryRepository;
import com.ttpsc.springtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;


    public List<Category> getCategories(Long userId){
        return categoryRepository.getUsersCategories(userId);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category getCategoryByName(String name, Long userId) {
        return categoryRepository.getCategoriesByName(name, userId);
    }

    public void addCategoryForUser(Category category, String username) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        category.setOwner(user);

        categoryRepository.save(category);
    }

    public void updateCategory(Long id, Category category) {
        Category categoryFromDB = categoryRepository.findById(id).orElseThrow();

        categoryFromDB.setName(category.getName());
        categoryFromDB.setDescription(category.getDescription());

        categoryRepository.save(categoryFromDB);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }

}

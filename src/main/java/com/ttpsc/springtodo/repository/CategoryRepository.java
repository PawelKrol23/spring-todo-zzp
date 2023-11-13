package com.ttpsc.springtodo.repository;

import com.ttpsc.springtodo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM categories c WHERE c.owner.id = :userId")
    List<Category> getUsersCategories(Long userId);

    @Query("SELECT c FROM categories c WHERE c.name = :name")
    Category getCategoriesByName(String name);
}

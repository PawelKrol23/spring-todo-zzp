package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Category;
import com.ttpsc.springtodo.model.Status;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.service.CategoryService;
import com.ttpsc.springtodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("/category")
    public String addCategoryView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        List <Category> loggedUsersCategories = categoryService.getCategories(loggedUser.getId());
        model.addAttribute("categories",loggedUsersCategories);
        return "addCategory";
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

}
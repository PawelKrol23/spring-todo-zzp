package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Category;
import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.service.CategoryService;
import com.ttpsc.springtodo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("/category")
    public String categoryListView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        List <Category> loggedUsersCategories = categoryService.getCategories(loggedUser.getId());
        model.addAttribute("categories",loggedUsersCategories);
        return "category/list";
    }

    @GetMapping("/category/add")
    public String addCategoryView(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/category/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "category/add";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        categoryService.addCategoryForUser(category, username);
        return "redirect:/category";
    }

    @GetMapping("/category/{id}")
    public String categoryEditForm(Model model,
                                   @PathVariable Long id){
        model.addAttribute("category", categoryService.getCategory(id));
        return "category/edit";
    }

    @PutMapping("/category/{id}")
    public String editCategorySubmit(@Valid @ModelAttribute("category") Category category, @PathVariable Long id, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "category/edit";
        }

        categoryService.updateCategory(id, category);
        return "redirect:/category";
    }

    @PostMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        Category category = categoryService.getCategory(id);
        categoryService.delete(category);
        return "redirect:/category";
    }



}



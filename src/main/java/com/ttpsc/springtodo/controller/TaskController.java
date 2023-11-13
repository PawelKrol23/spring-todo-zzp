package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.*;
import com.ttpsc.springtodo.service.CategoryService;
import com.ttpsc.springtodo.service.StatusService;
import com.ttpsc.springtodo.service.TaskService;
import com.ttpsc.springtodo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final StatusService statusService;

    @GetMapping("/tasks")
    public String getUsersTasks(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        List <Task> usersTasks = loggedUser.getTasks();
        model.addAttribute("tasks", usersTasks);
        return "tasks";
    }

    @GetMapping("/editTasks")
    public String editTaskView(){
        return "editTasks";
    }

    @GetMapping("/task/add")
    public String addTaskForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        model.addAttribute("task",new TaskDTO());
        model.addAttribute("categories",categoryService.getCategories(loggedUser.getId()));
        model.addAttribute("statuses",statusService.getStatuses(loggedUser.getId()));
        return "addTasks";
    }

    @PostMapping("/task/add")
    public String addTask(@Valid @ModelAttribute ("task") TaskDTO dto,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "redirect:/task/add";
        }
        Category category = categoryService.getCategoryByName(dto.getCategoryName());
        Status status = statusService.getStatusByName(dto.getStatusName());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());

        Task task = new Task();
        task.setOwner(userService.getUserById(loggedUser.getId()));
        task.setSummary(dto.getSummary());
        task.setDescription(dto.getDescription());
        task.setStartDate(dto.getStartDate());
        task.setEndDate(dto.getEndDate());
        task.setTaskCategory(category);
        task.setStatus(status);
        taskService.save(task);

        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
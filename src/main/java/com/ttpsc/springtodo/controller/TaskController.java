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
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


    @GetMapping("/task/add")
    public String addTaskForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String startDate = LocalDateTime.now().format(formatter);
        String endDate = LocalDateTime.now().plusHours(2).format(formatter);

        model.addAttribute("task",new TaskDTO());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("categories",categoryService.getCategories(loggedUser.getId()));
        model.addAttribute("statuses",statusService.getStatuses(loggedUser.getId()));
        return "addTasks";
    }

    @PostMapping("/task/add")
    public String addTask(@Valid @ModelAttribute ("task") TaskDTO dto,
                          BindingResult bindingResult) {
        System.out.println(dto.getStartDate());
        System.out.println(dto.getEndDate());
        if(bindingResult.hasErrors()) {
            return "redirect:/task/add";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());

        Category category = categoryService.getCategoryByName(dto.getCategoryName(), loggedUser.getId());
        Status status = statusService.getStatusByName(dto.getStatusName(), loggedUser.getId());


        Task task = new Task();
        task.setOwner(userService.getUserById(loggedUser.getId()));
        task.setSummary(dto.getSummary());
        task.setDescription(dto.getDescription());
        task.setStartDate(LocalDateTime.parse(dto.getStartDate()));
        task.setEndDate(LocalDateTime.parse(dto.getEndDate()));
        task.setTaskCategory(category);
        task.setStatus(status);
        taskService.save(task);


        return "redirect:/tasks";
    }

    @GetMapping("/task/edit/{id}")
    public String editTaskForm(Model model,@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Task task = taskService.getTask(id);
        String startDate = task.getStartDate().format(formatter);
        String endDate = task.getEndDate().format(formatter);

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("categories",categoryService.getCategories(loggedUser.getId()));
        model.addAttribute("statuses",statusService.getStatuses(loggedUser.getId()));
        model.addAttribute("task",task);
        model.addAttribute("dto",new TaskDTO());
        return "editTasks";
    }

    @PostMapping("/task/edit/{id}")
    public String editTask(TaskDTO dto, @PathVariable Long id,
                           BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "redirect:/task/edit/"+id;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());

        Category category = categoryService.getCategoryByName(dto.getCategoryName(),loggedUser.getId());
        Status status = statusService.getStatusByName(dto.getStatusName(), loggedUser.getId());
        LocalDateTime startDate = LocalDateTime.parse(dto.getStartDate());
        LocalDateTime endDate = LocalDateTime.parse(dto.getEndDate());

        Task task = new Task();
        task.setSummary(dto.getSummary());
        task.setDescription(dto.getDescription());
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setTaskCategory(category);
        task.setStatus(status);

        taskService.updateTask(id,task);

        return "redirect:/tasks";
    }

    @PostMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        taskService.delete(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
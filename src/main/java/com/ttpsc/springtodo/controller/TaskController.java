package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.service.TaskService;
import com.ttpsc.springtodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

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

    @GetMapping("/addTasks")
    public String AddTaskView(){
        return "addTasks";
    }

    public String listTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
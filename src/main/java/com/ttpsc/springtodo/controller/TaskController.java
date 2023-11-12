package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.service.TaskService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/user/{id}/tasks")
    public List<Task> getUsersTasks(@PathVariable Long id) {
        return taskService.getTasks(id);
    }


    @GetMapping("/editTasks")
    public String editTaskView(){
        return "editTasks";
    }

    @GetMapping("/addTasks")
    public String AddTaskView(){
        return "addTasks";
    }

    @GetMapping("/tasks")
    public String listTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks(); // Get tasks from your service or repository
        model.addAttribute("tasks", tasks);
        return "tasks"; // The name of your Thymeleaf template
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
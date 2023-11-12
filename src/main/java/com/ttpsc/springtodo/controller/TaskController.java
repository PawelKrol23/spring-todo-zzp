package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/user/{id}/tasks")
    public List<Task> getUsersTasks(@PathVariable Long id) {
        return taskService.getTasks(id);
    }

    @GetMapping("/tasks")
    public String showAllTasks() {
        return "tasks";
    }

    @GetMapping("/addTasks")
    public String AddTaskView(){
        return "addTasks";
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
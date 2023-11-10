package com.ttpsc.springtodo.controler;

import com.ttpsc.springtodo.model.Category;
import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.service.CategoryService;
import com.ttpsc.springtodo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/user/{id}/tasks")
    public List<Task> getUsersTasks(@PathVariable Long id) {
        return taskService.getTasks(id);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
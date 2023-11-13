package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.Task;
import com.ttpsc.springtodo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TaskService {
    private final TaskRepository taskRepository;


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public List<Task> getTasks(Long id){
        return taskRepository.getUsersTasks(id);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Long id,Task task) {
        Task pulled = taskRepository.findById(id).orElseThrow();

        pulled.setSummary(task.getSummary());
        pulled.setDescription(task.getDescription());
        pulled.setStartDate(task.getStartDate());
        pulled.setEndDate(task.getEndDate());
        pulled.setTaskCategory(task.getTaskCategory());
        pulled.setStatus(task.getStatus());

        taskRepository.save(pulled);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}

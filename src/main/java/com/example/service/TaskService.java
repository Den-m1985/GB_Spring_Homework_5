package com.example.service;

import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;


    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findTasksByTaskStatus(status);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> optionalTask = getTaskById(id);
        if (optionalTask.isPresent()) {
            Task task1 = optionalTask.get();
            task1.setDescription(task.getDescription());
            task1.setTaskStatus(task.getTaskStatus());
            task1.setLocalDateTime(task.getLocalDateTime());
            return repository.save(task1);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}

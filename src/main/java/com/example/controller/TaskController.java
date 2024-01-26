package com.example.controller;

import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;


    /**
     * Handles the HTTP POST request to create a new task.
     *
     * @param task The task object to be created. Should be provided in the request body as JSON.
     * @return The newly created task object with its unique identifier.
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }


    /**
     * Handles the HTTP GET request to retrieve a list of all tasks.
     *
     * @return A list of tasks containing information about each task in the system.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    /**
     * Handles the HTTP GET request to retrieve a list of tasks based on their status.
     *
     * @param status The status of tasks to filter by.
     * @return A list of tasks with the specified status.
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }


    /**
     * Handles the HTTP PUT request to update the status of a specific task.
     *
     * @param id   The unique identifier of the task to be updated.
     * @param task The task object containing the updated status. Should be provided in the request body as JSON.
     * @return The updated task object with its modified status.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatus(id, task);
    }


    /**
     * Handles the HTTP DELETE request to delete a specific task.
     *
     * @param id The unique identifier of the task to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}

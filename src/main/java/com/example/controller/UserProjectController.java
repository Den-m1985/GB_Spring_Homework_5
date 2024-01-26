package com.example.controller;

import com.example.model.Project;
import com.example.model.User;
import com.example.service.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-user")
@AllArgsConstructor
public class UserProjectController {
    private final UserProjectService userProjectService;


    // strong
    @GetMapping("/users/{projectId}")
    public ResponseEntity<List> getUsersByProjectId(@PathVariable Long projectId){
        // метод, обрабатывающий GET-запрос для получения списка пользователей, связанных с определенным проектом
        List<User> users = userProjectService.getUsersByProjectId(projectId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/projects/{userId}")
    public ResponseEntity<List> getProjectsByUserId(@PathVariable Long userId){
        // метод, обрабатывающий GET-запрос для получения списка проектов, связанных с определенным пользователем
        List<Project> projects = userProjectService.getProjectsByUserId(userId);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/add-user-to-project/{userId}/{projectId}")
    public ResponseEntity addUserToProject(@PathVariable Long userId, @PathVariable Long projectId){
        // метод, обрабатывающий POST-запрос для добавления пользователя к проекту
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove-user-from-project/{userId}/{projectId}")
    public ResponseEntity removeUserFromProject(@PathVariable Long userId, @PathVariable Long projectId){
        // метод, обрабатывающий POST-запрос для удаления пользователя из проекта
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

}

package com.example.controller;

import com.example.model.Project;
import com.example.model.User;
import com.example.model.UsersProject;
import com.example.service.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-user")
@AllArgsConstructor
public class UserProjectController {
    @Autowired
    private final UserProjectService userProjectService;


    /**
     * Обрабатывает GET-запрос для получения списка пользователей, связанных с определенным проектом.
     *
     * @param projectId Идентификатор проекта, для которого необходимо получить список пользователей.
     * @return Ответ с HTTP-статусом 200 (OK) и списком пользователей, либо пустым списком, если связанных пользователей нет.
     */
    @GetMapping("/users/{projectId}")
    public ResponseEntity<List> getUsersByProjectId(@PathVariable Long projectId) {
        List<User> users = userProjectService.getUsersByProjectId(projectId);
        return ResponseEntity.ok(users);
    }


    /**
     * Обрабатывает GET-запрос для получения списка проектов, связанных с определенным пользователем.
     *
     * @param userId Идентификатор пользователя, для которого необходимо получить список проектов.
     * @return Ответ с HTTP-статусом 200 (OK) и списком проектов, либо пустым списком, если связанных проектов нет.
     */
    @GetMapping("/projects/{userId}")
    public ResponseEntity<List> getProjectsByUserId(@PathVariable Long userId) {
        List<Project> projects = userProjectService.getProjectsByUserId(userId);
        return ResponseEntity.ok(projects);
    }


    /**
     * Обрабатывает POST-запрос для добавления пользователя к проекту.
     *
     * @param userId    Идентификатор пользователя, который будет добавлен к проекту.
     * @param projectId Идентификатор проекта, к которому будет добавлен пользователь.
     * @return Ответ с HTTP-статусом 200 (OK), указывающий на успешное добавление пользователя к проекту.
     */
    @PostMapping("/add-user-to-project/{userId}/{projectId}")
    public ResponseEntity addUserToProject(@PathVariable Long userId, @PathVariable Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }


    /**
     * Обрабатывает POST-запрос для удаления пользователя из проекта.
     *
     * @param userId    Идентификатор пользователя, который будет удален из проекта.
     * @param projectId Идентификатор проекта, из которого будет удален пользователь.
     * @return Ответ с HTTP-статусом 200 (OK), указывающий на успешное удаление пользователя из проекта.
     */
    @PostMapping("/remove-user-from-project/{userId}/{projectId}")
    public ResponseEntity removeUserFromProject(@PathVariable Long userId, @PathVariable Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }


    /**
     * Обрабатывает GET-запрос для получения списка всех проектов.
     *
     * @return Ответ с HTTP-статусом 200 (OK) и списком проектов в теле ответа.
     */
    @GetMapping("/projects")
    public ResponseEntity<List> getProjects() {
        List<Project> projects = userProjectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }


    /**
     * Обрабатывает GET-запрос для получения списка всех связей пользователей с проектами.
     *
     * @return Ответ с HTTP-статусом 200 (OK) и списком связей пользователей с проектами в теле ответа.
     */
    @GetMapping("/users-project")
    public ResponseEntity<List> getUsersProject() {
        List<UsersProject> usersProject = userProjectService.getUsersProject();
        return ResponseEntity.ok(usersProject);
    }

}

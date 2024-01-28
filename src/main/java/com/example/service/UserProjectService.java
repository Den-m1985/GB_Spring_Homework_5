package com.example.service;

import com.example.model.Project;
import com.example.model.User;
import com.example.model.UsersProject;
import com.example.repository.ProjectRepository;
import com.example.repository.UserRepository;
import com.example.repository.UsersProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {
    private final ProjectRepository projectRepository;
    private final UsersProjectRepository usersProjectRepository;
    private final UserRepository userRepository;


    // метод, возвращающий список пользователей, связанных с определенным проектом
    public List<User> getUsersByProjectId(Long projectId) {
        return userRepository.findUsersByProjectId(projectId);
    }

    // метод, возвращающий список проектов, связанных с определенным пользователем
    public List<Project> getProjectsByUserId(Long userId) {
        return projectRepository.findProjectsByUserId(userId);
    }

    // метод, добавляющий пользователя к проекту
    public void addUserToProject(Long userId, Long projectId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        user.getProjects().add(project);
        userRepository.save(user);
    }

    // метод, удаляющий пользователя из проекта
    public void removeUserFromProject(Long userId, Long projectId) {
        // usersProjectRepository.deleteByUserIdAndProjectId(userId, projectId);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<UsersProject> getUsersProject() {
        return usersProjectRepository.findAll();
    }

}

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
        List<UsersProject> usersProjects = usersProjectRepository.findByProjectId(projectId);
        return userRepository.findAllById(usersProjects.stream().map(UsersProject::getUserId).toList());
    }



    // метод, возвращающий список проектов, связанных с определенным пользователем
    public List<Project> getProjectsByUserId(Long userId) {
        List<UsersProject> usersProjects = usersProjectRepository.findByUserId(userId);
        return projectRepository.findAllById(usersProjects.stream().map(UsersProject::getProjectId).toList());
    }




    // метод, добавляющий пользователя к проекту
    public void addUserToProject(Long userId, Long projectId) {
        UsersProject usersProject = new UsersProject();
        usersProject.setUserId(userId);
        usersProject.setProjectId(projectId);
        usersProjectRepository.save(usersProject);
    }



    // метод, удаляющий пользователя из проекта
    public void removeUserFromProject(Long userId, Long projectId) {
        usersProjectRepository.deleteByUserIdAndProjectId(userId, projectId);
    }


}

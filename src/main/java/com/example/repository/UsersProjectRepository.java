package com.example.repository;

import com.example.model.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    List<UsersProject> findByProjectId(Long projectId);
    List<UsersProject> findByUserId(Long userId);
    void deleteByUserIdAndProjectId(Long userId, Long projectId);
}

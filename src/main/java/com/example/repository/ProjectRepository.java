package com.example.repository;

import com.example.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT up.projectId FROM UsersProject up WHERE up.userId.id = :userId")
    List<Project> findProjectsByUserId(@Param("userId") Long userId);

}

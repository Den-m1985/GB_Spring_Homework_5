package com.example.repository;

import com.example.model.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {

}

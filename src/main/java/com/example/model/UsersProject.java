package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users_projects")
public class UsersProject extends EntityWithRelation {

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project projectId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

}

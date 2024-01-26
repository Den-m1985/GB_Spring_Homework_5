package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class UsersProject extends EntityWithRelation {
    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private Long userId;

}

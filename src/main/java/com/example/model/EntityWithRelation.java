package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class EntityWithRelation {
/*
Этот класс использует аннотацию @MappedSuperclass,
что означает, что это не сущность JPA, но все его
поля будут унаследованы дочерними сущностями
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long relatedEntityId;

}

package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String header;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, name = "local_date_time")
    private LocalDateTime localDateTime;

}

package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String summary;
    private String description;

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name="category", nullable=false)
    private Category taskCategory;
}

package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
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

    @ManyToOne
    @JoinColumn(name="status", nullable=false)
    private Status status;
}

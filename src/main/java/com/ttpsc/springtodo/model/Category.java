package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public String description;


    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;
}

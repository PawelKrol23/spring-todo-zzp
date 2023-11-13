package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 20)
    public String name;

    @Size(max = 20)
    public String description;


    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;
}

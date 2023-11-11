package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String displayname;

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;
}

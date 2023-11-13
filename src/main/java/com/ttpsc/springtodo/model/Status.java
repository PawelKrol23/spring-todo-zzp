package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "status_id_seq")
    @GenericGenerator(name = "status_id_seq", strategy = "increment")
    private Long id;
    private String name;
    private String displayname;

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;
}

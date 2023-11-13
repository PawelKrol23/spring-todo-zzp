package com.ttpsc.springtodo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Size(min = 2, max = 20)
    private String name;

    @Size(min = 2, max = 20)
    private String displayname;

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    private UserEntity owner;
}

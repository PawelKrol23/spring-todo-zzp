package com.ttpsc.springtodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;
    private String username;
    private String password;
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Status> statuses;

}

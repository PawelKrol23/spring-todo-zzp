package com.ttpsc.springtodo.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 5, max = 30)
    private String password;
}

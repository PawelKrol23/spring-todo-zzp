package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.UserDTO;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user/create";
    }

    @PostMapping("/user")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/create";
    }

    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

}

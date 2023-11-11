package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.User;
import com.ttpsc.springtodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

}

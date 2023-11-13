package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Status;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.service.StatusService;
import com.ttpsc.springtodo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    private final UserService userService;

    @GetMapping("/status")
    public String addStatusView(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = userService.getUserByName(authentication.getName());
        List <Status> loggedUsersStatuses = statusService.getStatuses(loggedUser.getId());
        model.addAttribute("statuses",loggedUsersStatuses);
        return "status/list";
    }

    @GetMapping("/status/add")
    public String statusCreationForm(Model model){
        model.addAttribute("status", new Status());
        return "status/add";
    }

    @PostMapping("/status/add")
    public String statusCreationSubmit(@Valid @ModelAttribute("status") Status status,
                                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "status/add";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        statusService.addStatusForUser(status, username);
        return "redirect:/status";
    }
}

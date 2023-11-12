package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Status;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.service.StatusService;
import com.ttpsc.springtodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "addStatus";
    }


}
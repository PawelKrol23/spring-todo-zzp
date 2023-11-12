package com.ttpsc.springtodo.controller;

import com.ttpsc.springtodo.model.Status;
import com.ttpsc.springtodo.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class StatusController {

private final StatusService statusService;

    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable Long id) {
        return statusService.getStatus(id);
    }

    @GetMapping("/status")
    public String addStatusView(){
        return "addStatus";
    }

    @GetMapping("/user/{id}/status")
    public List<Status> getUsersStatuses(@PathVariable Long id) {
        return statusService.getStatuses(id);
    }

}
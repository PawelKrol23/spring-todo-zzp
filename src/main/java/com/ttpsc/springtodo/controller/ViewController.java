package com.ttpsc.springtodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping()
    public String HomepageView(){
        return "homepage";
    }

    @GetMapping("/task")
    public String TaskView(){
        return "task";
    }
}

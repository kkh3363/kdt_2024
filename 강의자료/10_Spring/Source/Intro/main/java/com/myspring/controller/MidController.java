package com.myspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MidController {
    @GetMapping(value="mid")
    public String mid(){
        return "hello-mvc";
    }
}

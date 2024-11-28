package com.kdt.testauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping("/my")
    @ResponseBody
    public String myApi(){
        return "My route";
    }
}

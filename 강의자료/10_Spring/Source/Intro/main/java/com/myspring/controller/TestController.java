package com.myspring.controller;

import com.myspring.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class TestController {
    @GetMapping("test")
    @ResponseBody // viewResolver 사용 X
    public UserDto test() {
        UserDto user = new UserDto();
        user.setName("kim");
        user.setAge(20);

        return user;
    }
}

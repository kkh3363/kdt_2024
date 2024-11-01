package com.myspring.controller;

import com.myspring.domain.Member;
import com.myspring.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeController {
    @GetMapping("ttl")
    public String ttl(Model model){
        model.addAttribute("data","Hello!!");
        return "thyme.html";
    }
    @GetMapping("ttlList")
    public String ttlList(Model model){
        Member m1 = new Member();
        Member m2 = new Member();
        m1.setId(1L); m1.setName("kim");
        m2.setId(2L); m2.setName("Lee");;

        List<Member> list = new ArrayList<>();
        list.add(m1); list.add(m2);
        Map<String, Member> map = new HashMap<>();
        map.put("userA", m1);
        map.put("userB", m2);

        model.addAttribute("user", m1);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);
        return "ttllist";
    }
    @GetMapping("ttl-basic")
    public String ttlBasic(HttpSession session){
        session.setAttribute("sessionData", "Hello Session");
        return "ttl-basic";
    }
    @Component("helloBean")
    static class HelloBean {
        public String hello(String data){
            return  "Hello : " + data;
        }
    }
    @GetMapping("ttl-link")
    public String ttlLink( Model model){
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "ttl-link";
    }


    @GetMapping("ttl-each")
    public String ttlEach( Model model){
        List<User> list = new ArrayList<>();
        list.add(new User("kim"));
        list.add(new User("lee"));
        list.add(new User("park"));
        model.addAttribute("users", list);
        return "ttl-each";
    }

}

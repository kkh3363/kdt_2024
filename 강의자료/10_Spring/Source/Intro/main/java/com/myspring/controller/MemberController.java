package com.myspring.controller;

import com.myspring.domain.Member;
import com.myspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/member/new")
    public String createForm(){
        return "member/createMemberForm";
    }
    @PostMapping(value = "/member/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping(value = "/member")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        System.out.println("----"+ members.size());
        model.addAttribute("members", members);
        return "member/memberList";
    }
}

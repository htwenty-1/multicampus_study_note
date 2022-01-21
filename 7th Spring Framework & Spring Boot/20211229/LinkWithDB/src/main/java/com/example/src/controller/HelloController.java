package com.example.src.controller;


import MemberDto.MemberDto;
import Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {


    MemberService service = new MemberService();

    @GetMapping("/")
    public String hello(Model model) {
        System.out.println("HelloController hello()" + new Date());


        // DB 접근
        List<MemberDto> list = service.allMember();
        model.addAttribute("list", list);
        return "hello";
    }

    @GetMapping("home")
    public String home(Model model, MemberDto dto) {
        System.out.println(dto.toString());

        MemberDto mem = service.getMember(dto);
        model.addAttribute("mem", mem);

        return "home";
    }

}

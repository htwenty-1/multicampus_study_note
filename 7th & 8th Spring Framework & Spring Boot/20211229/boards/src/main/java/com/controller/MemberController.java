package com.controller;

import com.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService service;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("regi")
    public String regi() {
        return "regi";
    }

}

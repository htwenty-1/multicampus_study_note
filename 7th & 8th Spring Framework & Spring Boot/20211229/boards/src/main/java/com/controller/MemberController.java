package com.controller;

import com.dto.MemberDto;
import com.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {


    @Autowired
    MemberService service;

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "regi.do", method = RequestMethod.GET)
    public String regi() {
        return "regi";
    }

    @RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
    public String regiAf(MemberDto dto) {

        boolean b = service.addMember(dto);
        if (b) {
            System.out.println("Success");
        }
        return "login";
        // return "redirect:/login";
    }

    @ResponseBody       // ajax
    @RequestMapping(value = "idCheck.do", method = RequestMethod.POST)
    public String idCheck(String id) {
        System.out.println("MemberController idCheck(), id: " + id);

        int cnt = service.getId(id);

        System.out.println(cnt);

        if (cnt > 0) {
            return "Unusable";
        } else {
            return "Usable";
        }
    }

}

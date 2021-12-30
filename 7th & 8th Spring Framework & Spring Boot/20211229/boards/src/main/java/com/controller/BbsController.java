package com.controller;

import com.dto.BbsDto;
import com.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class BbsController {

    @Autowired
    BbsService service;

    @RequestMapping(value= "bbslist.do", method= RequestMethod.GET)
    public String bbslist(Model model) {
        System.out.println("BbsController bbslist()" + new Date());
        List<BbsDto> list = service.bbslist();
        model.addAttribute("bbslist", list);
        return "bbslist";
    }

    @RequestMapping(value= "bbswrite.do", method= RequestMethod.GET)
    public String bbswrite() {
        return "bbswrite";
    }

    @RequestMapping(value="writebbs.do", method= RequestMethod.GET)
    public String writebbs(Model model) {
        System.out.println("BbsController writebbs()" + new Date());
        List<BbsDto> list = service.bbslist();
        model.addAttribute("writebbslist", list);
        return "bbswriteAf";
    }

}

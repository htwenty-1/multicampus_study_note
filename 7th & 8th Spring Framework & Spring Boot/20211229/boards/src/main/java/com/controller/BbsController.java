package com.controller;

import com.dto.BbsDto;
import com.dto.BbsParam;
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
    public String bbslist(Model model, BbsParam param) {
        System.out.println("BbsController bbslist()" + new Date());
        List<BbsDto> list = service.bbslist(param);
        model.addAttribute("bbslist", list);
        return "bbslist";
    }

    @RequestMapping(value= "bbswrite.do", method= RequestMethod.GET)
    public String bbswrite() {
        return "bbswrite";
    }

    @RequestMapping(value="bbswriteAf.do", method= RequestMethod.POST)
    public String bbswriteAf(BbsDto dto) {
        System.out.println("BbsController bbswriteAf() " + new Date());
        System.out.println(dto.toString());

        boolean b = service.writebbs(dto);
        if (b) {
            System.out.println("글이 정상적으로 업로드 됨.");
        }

        return "redirect:/bbslist.do";
    }

    @RequestMapping(value="bbsdetail.do", method= RequestMethod.GET)
    public String bbsdetail(int seq, Model model) {
        System.out.println("seq: " + seq);

        BbsDto bbs = service.getBbs(seq);
        model.addAttribute("bbs", bbs);

        return "bbsdetail";
    }

    @RequestMapping(value="answer.do", method= RequestMethod.GET)
    public String answer (int seq, Model model) {
        System.out.println("BbsController answer() " + new Date());

        BbsDto bbs = service.getBbs(seq);
        model.addAttribute("bbs", bbs);

        return "bbsanswer";

    }

    @RequestMapping(value="answerAf.do", method= RequestMethod.GET)
    public String answerAf(int seq, BbsDto dto) {
        System.out.println("BbsController answerAf() " + new Date());

        // DB 접근 ==> update와 insert 다 해야함
        dto.setSeq(seq);


        return "redirect:/bbslist.do";
    }

}

package com.example.src.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HelloController {

//	@GetMapping("/test")
//	public String test() {
//		return "HELLO";
//	}

	@GetMapping("/")
	public String hello(Model model) {
		System.out.println("HelloController hello()");
		return "hello";
	}

	@GetMapping("home")
	public String hello() {
		System.out.println("HelloController home()");
		return "home";
	}

//	@GetMapping("alias")
	@ResponseBody
	 @RequestMapping(value = "alias.do",
		 			 method = RequestMethod.GET,
		 			 produces="application/String; " +
						      "charset=utf-8")
	public String alias(String alias) {
		System.out.println("alias = " + alias);

		if(alias.equals("라이언")) {
			return "good Name";
		}
		return "normal name";
	}
}

package com.example.src.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

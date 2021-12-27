package com.example.src.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class TestController {

//	@GetMapping("/test")
//	public String test() {
//		return "HELLO";
//	}

//	@GetMapping("/")
//	public String getTime() {
//		return "index";
//	}

	@GetMapping("/")
	public String inputName() {
		return "myNameIs";
	}
}

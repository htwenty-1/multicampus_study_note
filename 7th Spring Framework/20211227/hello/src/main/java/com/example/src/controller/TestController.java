package com.example.src.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class TestController {

	@GetMapping("/")
	public String inputName() {
		return "index";
	}


	@GetMapping("/myname")
	public String printName() {
		return "myName";
	}
}

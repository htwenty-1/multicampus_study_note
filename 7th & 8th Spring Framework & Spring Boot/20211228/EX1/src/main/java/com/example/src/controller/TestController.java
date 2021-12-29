package com.example.src.controller;

import com.example.src.dto.humanDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

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
	public String home() {
		return "world";
	}

//	@GetMapping("account")
//	public String account(String name, int age) {
////		Logger.info("HelloController account()");
//
//		System.out.println(name + ", " + age);
//		return "ex";
//	}

	@PostMapping("account")
	public String account(humanDto human) {
		System.out.println(human.getName());
		System.out.println(human.getAge());
		return "ex";
	}

}

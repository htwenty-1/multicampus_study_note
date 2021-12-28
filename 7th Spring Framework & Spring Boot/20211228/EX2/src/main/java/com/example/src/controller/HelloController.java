package com.example.src.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("hello")
	public String hello () {
		System.out.println("HelloController hello() " + new Date());

		return "hello";
	}

}

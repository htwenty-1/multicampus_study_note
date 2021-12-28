package com.example.src.controller;

import com.example.src.dto.HumanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

//	@GetMapping("hello")
//	public String hello () {
//		System.out.println("HelloController hello() " + new Date());
//
//		return "hello";
//	}

	// 데이터를 프론트엔드단으로 가져가기 ===> Model로 짐싸!
	@GetMapping("hello")
	public String hello (Model model) {
		System.out.println("HelloController hello() " + new Date());

		String name = "성춘향";
		model.addAttribute("_name", name);	// name이라는 Object로 name을 보냄

		return "hello";	// 짐쌌으니 이동해
	}

	@GetMapping("home")
	public String home (Model model) {
		String job = "의사";
		Integer age = 24;
		model.addAttribute("job", job);
		model.addAttribute("age", age);

		return "home";
	}			// 넘겨줄 데이터가 많으면 DTO 사용하기

	@GetMapping("world")
	public String world (Model model) {
		System.out.println("HelloController world()" + new Date());
		List<HumanDto> list = new ArrayList<>();
		list.add(new HumanDto("프로그래머", 15));
		list.add(new HumanDto("게이머", 18));
		list.add(new HumanDto("의사", 45));

		model.addAttribute("list", list);

		return "world";

	}

}

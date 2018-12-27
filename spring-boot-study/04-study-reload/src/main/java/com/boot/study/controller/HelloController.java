package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		return "hello world jreble";
	}

	@GetMapping("/2")
	public String hello2() {
		return "hello world2";
	}

	@GetMapping("/3")
	public String hello3() {
		return "hello world3";
	}

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "HD");
		map.put("age", 18);

		return map;
	}
}

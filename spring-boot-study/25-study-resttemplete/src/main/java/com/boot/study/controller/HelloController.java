package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		return "hello world";
	}

	@PostMapping("/map")
	public Map<String, Object> map(@RequestHeader String token, @RequestBody String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("age", 18);
		map.put("token", token);

		return map;
	}
}

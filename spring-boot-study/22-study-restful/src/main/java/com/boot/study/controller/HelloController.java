package com.boot.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoos")
public class HelloController {

	@GetMapping(params = "name")
	public List<String> hello(String name) {
		List<String> list = new ArrayList<>();
		list.add("zoo1");
		list.add("zoo2");
		list.add("zoo3");

		return list;
	}

	@PostMapping
	public Map<String, Object> map(String string) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", string);

		return map;
	}

	@PutMapping
	public void update(String string) {

	}

	@GetMapping("/{id}")
	public String getByid(@PathVariable Long id) {
		return "zoo" + id;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
	}
}

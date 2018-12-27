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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/zoos")
public class HelloController {

	@ApiOperation(value = "获取所有动物园")
	@GetMapping(params = "name")
	public List<String> hello(@ApiParam(value = "名字", allowableValues = "first, second, third") String name) {
		List<String> list = new ArrayList<>();
		list.add("zoo1");
		list.add("zoo2");
		list.add("zoo3");

		return list;
	}

	@PostMapping
	public Map<String, Object> map(@RequestBody Hello hello) {
		Map<String, Object> map = new HashMap<>();
		map.put("hello", hello);

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

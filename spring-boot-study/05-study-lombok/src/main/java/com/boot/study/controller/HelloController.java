package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.model.TestModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		log.info("lombok");

		TestModel testModel = new TestModel();
		testModel.setAge(10);
		testModel.setName("33");

		testModel = TestModel.builder().name("44").age(20).build();

		return "hello world";
	}

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "HD");
		map.put("age", 18);

		return map;
	}
}

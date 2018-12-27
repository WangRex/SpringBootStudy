package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.config.Hello;
import com.boot.study.service.CacheService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private CacheService cacheService;

	@GetMapping
	public Hello hello(String name) {

		return cacheService.hello(name);
	}

	@GetMapping("/map")
	public Map<String, Object> map(String name) {
		Map<String, Object> map = new HashMap<>();
//		cacheService.update(name);
		cacheService.delete(name);
		return map;
	}
}

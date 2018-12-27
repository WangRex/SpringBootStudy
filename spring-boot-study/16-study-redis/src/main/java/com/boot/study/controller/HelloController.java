package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.config.Hello;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private RedisTemplate<String, Hello> redisTemplate;
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;

	@GetMapping
	public String hello() {
		Hello hello = new Hello();
		hello.setAge(100);
		hello.setName("nihao");
		redisTemplate.opsForValue().set("hello", hello);

		return "hello world";
	}

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("hello", redisTemplate.opsForValue().get("hello"));

		return map;
	}
}

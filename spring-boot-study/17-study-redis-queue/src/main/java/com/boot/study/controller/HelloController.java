package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

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

	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	@GetMapping
	public String hello() {
		for (int i = 0; i < 10; i++) {
			Hello hello = new Hello();
			hello.setAge(atomicInteger.getAndIncrement());
			hello.setName(UUID.randomUUID().toString());
			redisTemplate.opsForList().rightPush("my:list", hello);
		}

		return "hello world";
	}

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("hello", redisTemplate.opsForValue().get("hello"));

		return map;
	}
}

package com.boot.study.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.boot.study.config.Hello;

@Service
public class CacheService {

	@Cacheable(value = "names", key = "'names:' + #name")
	public Hello hello(String name) {
		// select * from *** where name = ?
		Hello hello = new Hello();
		hello.setName(name);
		System.out.println("我被执行了：name=" + name);

		return hello;
	}

	@CachePut(value = "names", key = "'names:' + #name")
	public Hello update(String name) {
		Hello hello = new Hello();
		hello.setName(name + "update");
		System.out.println("我被执行了update：name=" + name);

		return hello;
	}

	@CacheEvict(value = "names", key = "'names:' + #name")
	public Hello delete(String name) {
		Hello hello = new Hello();
		hello.setName(name + "delete");
		System.out.println("我被执行了delete：name=" + name);

		return hello;
	}
}

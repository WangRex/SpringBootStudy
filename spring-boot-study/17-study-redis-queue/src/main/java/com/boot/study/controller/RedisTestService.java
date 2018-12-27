package com.boot.study.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.boot.study.config.Hello;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RedisTestService implements InitializingBean {

	@Autowired
	private RedisTemplate<String, Hello> redisTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		new Thread(() -> {
			while (true) {
				try {
					Hello hello = redisTemplate.opsForList().leftPop("my:list", 10, TimeUnit.SECONDS);
					if (hello != null) {
						// TODO
						log.info("{}", hello);
					}
				} catch (Exception e) {
					e.printStackTrace();
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}).start();
	}
}

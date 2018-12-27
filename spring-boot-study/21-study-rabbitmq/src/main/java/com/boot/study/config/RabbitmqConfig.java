package com.boot.study.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

	@Bean
	public Queue queue() {
		return new Queue("study.q1", true);
	}

	@RabbitListener(queues = "study.q1")
	public void hello(String hello) {
		System.out.println(hello);
	}

}

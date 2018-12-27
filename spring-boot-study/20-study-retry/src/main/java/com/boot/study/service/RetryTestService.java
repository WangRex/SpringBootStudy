package com.boot.study.service;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryTestService {

	@Retryable(maxAttempts = 2)
	public void hello() {

		System.out.println("nihao");
		System.out.println(1 / 0);
	}
}

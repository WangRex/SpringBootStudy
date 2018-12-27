package com.boot.study.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JobService {

	public void hello() {
		log.info("hello");
	}
}

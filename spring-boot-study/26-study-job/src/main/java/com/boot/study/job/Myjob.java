package com.boot.study.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableScheduling
public class Myjob {

	@Scheduled(cron = "${cron.job1}")
	public void job() {
		log.info("1");
	}
}

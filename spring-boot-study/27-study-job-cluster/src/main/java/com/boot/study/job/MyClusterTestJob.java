package com.boot.study.job;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.boot.study.config.JobConfig;
import com.boot.study.service.JobService;

public class MyClusterTestJob extends QuartzJobBean {

	@Override
	public void executeInternal(JobExecutionContext jobExecutionContext) {
		try {
			ApplicationContext applicationContext = (ApplicationContext) jobExecutionContext.getScheduler().getContext()
					.get(JobConfig.key);

			JobService jobService = applicationContext.getBean(JobService.class);

			jobService.hello();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}

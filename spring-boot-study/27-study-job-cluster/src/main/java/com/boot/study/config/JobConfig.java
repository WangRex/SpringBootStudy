package com.boot.study.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.boot.study.job.MyClusterTestJob;

@Configuration
public class JobConfig {

	@Autowired
	private DataSource dataSource;

	@Value("${cron.test}")
	private String testCron;

	public static final String key = "spring_key";

	@Bean("myTestScheduler")
	public SchedulerFactoryBean quartzScheduler() {
		SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

		quartzScheduler.setQuartzProperties(quartzProperties());
		quartzScheduler.setDataSource(dataSource);
		quartzScheduler.setOverwriteExistingJobs(true);
		quartzScheduler.setApplicationContextSchedulerContextKey(key);

		Trigger[] triggers = { myTestTrigger().getObject() };
		quartzScheduler.setTriggers(triggers);

		return quartzScheduler;
	}

	@Bean
	public JobDetailFactoryBean myTestJob() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(MyClusterTestJob.class);
		jobDetailFactory.setDurability(true);
		jobDetailFactory.setDescription("测试jobdetail");

		return jobDetailFactory;
	}

	@Bean
	public CronTriggerFactoryBean myTestTrigger() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(myTestJob().getObject());
		cronTriggerFactoryBean.setCronExpression(testCron);
		cronTriggerFactoryBean.setDescription("测试trigger");
		return cronTriggerFactoryBean;
	}

	@Bean
	public Properties quartzProperties() {
		Properties properties = null;
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("quartz.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}
}

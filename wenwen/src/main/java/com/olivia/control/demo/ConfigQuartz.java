package com.olivia.control.demo;

import org.quartz.Scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class ConfigQuartz {
@Bean
public SchedulerFactoryBean schedulerFactoryBean(){
	return new SchedulerFactoryBean();
	
}
@Bean
public Scheduler scheduler(){
	return schedulerFactoryBean().getScheduler();
}
}

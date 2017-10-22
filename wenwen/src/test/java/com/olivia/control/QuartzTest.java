package com.olivia.control;




import org.quartz.JobBuilder;
import org.quartz.JobDetail;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzTest {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger=LoggerFactory.getLogger(QuartzTest.class);
		logger.info("begin your quartz travel");
		Scheduler scheduler = null;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
				scheduler.start();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		SimpleScheduleBuilder simpleScheduleBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatSecondlyForTotalCount(5);
	    JobDetail jobDetail=JobBuilder.newJob(FirstJob.class).withIdentity("job1","group1").build();
	    Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(simpleScheduleBuilder).build();
	  
	    try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

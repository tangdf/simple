package com.olivia.control;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstJob implements Job {
 
private  Logger logger= LoggerFactory.getLogger(FirstJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
       logger.info(arg0.getFireTime().toString());
       logger.info("定时炸弹bomm");
       logger.info(this.getClass().getName());
	}

}

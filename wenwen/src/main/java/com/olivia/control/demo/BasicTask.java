package com.olivia.control.demo;




import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BasicTask implements Job {
	@Autowired
    private Scheduler scheduler;
//	@PostConstruct
    public void init(){
    	
    	JobDetail jobDetail=JobBuilder.newJob(this.getClass()).withIdentity(this.getClass().getSimpleName()+"_job", this.getClass().getSimpleName()+"_group").build();
    	String rules=this.getRules();
    	CronScheduleBuilder cronScheduleBuilder=CronScheduleBuilder.cronSchedule(rules);
    	Trigger trigger=TriggerBuilder.newTrigger().withIdentity(this.getClass().getSimpleName()+"_trigger", this.getClass().getSimpleName()+"_group")
    			.withSchedule(cronScheduleBuilder).build();
    	
    	try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("please define your own job");
	}
	public String getRules(){
		return "0/10 * * * * ?";
	}
}

package com.olivia.control.demo;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

//一个常见的单例工具类 流水线作业重复工作
@Service
public class PojoRepeater extends BasicTask {
/*
 * private tool
 * */
	
	
	public void showAll(){
		System.out.println("too1.method invoking");
	    System.out.println("too2.method invoking"+System.currentTimeMillis()%10);
	    System.out.println("too3.method running");
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(arg0.getTrigger().getJobKey().getName());
		this.showAll();
		System.out.println("thisis assistent");
	}

	@Override
	public String getRules() {
		// TODO Auto-generated method stub
		return new String("0/4 * * * * ?");
	}
	
	
	
}

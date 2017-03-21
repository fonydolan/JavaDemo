package com.dolan.springbatch.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.FactoryBean;

public class CronTriggerFactoryBean implements FactoryBean<Trigger> {
	
	private final String jobName;
	
	private final String cronExpression;
	
	public CronTriggerFactoryBean(String jobName,String cronExpression){
		this.jobName = jobName;
		this.cronExpression = cronExpression;
	}

	@Override
	public Trigger getObject() throws Exception {
		// TODO Auto-generated method stub
		
		return TriggerBuilder.newTrigger()
				.forJob(jobName,"DEFAULT")
				.withIdentity(jobName+"Trigger","DEFAULT")
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
				.build();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Trigger.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}

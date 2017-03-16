package com.dolan.springbatch;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/*
Job listener is Optional and provide the opportunity to execute some business logic before job start 
and after job completed.For example setting up environment can be done before job 
and cleanup can be done after job completed.*/

public class ExamResultJobListener implements JobExecutionListener{
	
	static final String EXAMRESULT_JOB="ExamResult Job %s at: %s ";
	static final String EXAMRESULT_COSTTIME="Total time take in millis %d ";
	static final String EXAMRESULT_RESULT="ExamResult Job %s";
	static final String EXAMRESULT_EXCEPTION=" exception %s";
	
	private DateTime startTime,stopTime;
	
	@Override
	public void beforeJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		startTime = new DateTime();
		System.out.println(String.format(EXAMRESULT_JOB,"start", startTime.toString()));
		
	}

	@Override
	public void afterJob(JobExecution execution) {
		// TODO Auto-generated method stub
		stopTime = new DateTime();
		System.out.println(String.format(EXAMRESULT_JOB,"stop", stopTime.toString()));
		long time = getTimeInMillis(startTime,stopTime);
		System.out.println(String.format(EXAMRESULT_COSTTIME,time));
		
		BatchStatus status = execution.getStatus();
		if(status == BatchStatus.COMPLETED){
			System.out.println(String.format(EXAMRESULT_RESULT,"completed successfully"));
		}else if(status == BatchStatus.FAILED){
			System.out.println(String.format(EXAMRESULT_RESULT,"failed with following exception"));
			List<Throwable> exceptionList = execution.getAllFailureExceptions();
			for(Throwable th : exceptionList){
				System.out.println(String.format(EXAMRESULT_EXCEPTION,th.getLocalizedMessage()));
			}
			
		}
		
	}

	private long getTimeInMillis(DateTime start, DateTime stop) {
		// TODO Auto-generated method stub
		return stop.getMillis() - start.getMillis();
	}
	

}

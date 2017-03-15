package com.dolan.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	@SuppressWarnings("resource")
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-batch-context.xml");
        JobLauncher jobLauncher = (JobLauncher)context.getBean("jobLauncher");
        Job job = (Job)context.getBean("examResultJob");
        try
        {
        	JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Exit Status : "+ execution.getStatus());
        }
        catch(JobExecutionException e){
        	System.out.println("JOB ExamResult failed");
        	e.printStackTrace();
        }
        
    }
}

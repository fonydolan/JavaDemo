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
	static final String XML_TODATABASE_CONFIG="spring-batch-context.xml";
	static final String DATABASE_TOXML_CONFIG="spring-batch-context-dbtoxml.xml";
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext(DATABASE_TOXML_CONFIG);
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
    
    String XmlToDatabase(){
    	return "spring-batch-context.xml";
    }
}

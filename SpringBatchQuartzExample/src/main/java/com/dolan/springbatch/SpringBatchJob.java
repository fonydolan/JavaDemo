package com.dolan.springbatch;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;

public class SpringBatchJob {
	
	static final String DIRECTORY_PATH="D:/inputFiles";
	
	private String jobName;
	private JobLocator jobLocator;
	private JobLauncher jobLauncher;
	private File contentDirectory;
	
	public void setJobName(String jobName){
		this.jobName = jobName;
	}
	public void setJobLauncher(JobLauncher jobLauncher){
		this.jobLauncher = jobLauncher;
	}
	public void setJobLocator(JobLocator jobLocator){
		this.jobLocator = jobLocator;
	}
	
	public void init(){
		contentDirectory = new File(DIRECTORY_PATH);
	}
	
	boolean fileFound = false;
	
	public void performJob(){
		System.out.println("starting examresult job");
		
		try{
			if(this.contentDirectory == null || !this.contentDirectory.isDirectory()){
				System.err.println("input directory doesn't exist. job exam terminated");
			}
			fileFound = false;
			for(File file : this.contentDirectory.listFiles()){
				if(file.isFile()){
					String absolutePath =file.getAbsolutePath();
					System.out.println("file found:"+absolutePath);
					fileFound=true;
					
					JobParameter param = new JobParameter(absolutePath);
					Map<String,JobParameter> map = new HashMap<String,JobParameter>();
					map.put("examResultInputFile",param);
					map.put("date", new JobParameter(new Date()));
					
					JobExecution result = jobLauncher.run(jobLocator.getJob(jobName),new JobParameters(map));
					System.out.println("ExamResult job completion details : "+result.toString());
					
				}
			}
			if(!fileFound){
				System.out.println("no input file found, job terminated");
			}
			
			
		}catch(JobExecutionException e){
            System.out.println("ExamResult Job halted with following excpetion :" + e);
		}
	}
	
	
}

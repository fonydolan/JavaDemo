package com.dolan.hadoop.MapReduceDemo;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class MaxTemperatureJob {

    Job job;
	public MaxTemperatureJob(String[] inputPaths,String outputPath) throws IOException
	{
    	job = Job.getInstance();
	    job.setJarByClass(MaxTemperatureJob.class);
	    job.setJobName("Max Temperature");
		for(int i=0;i<inputPaths.length;i++)
		{
			FileInputFormat.addInputPath(job, new Path(inputPaths[i]));
		}
	    FileOutputFormat.setOutputPath(job, new Path(outputPath));
	    
	    job.setMapperClass(MaxTemperatureMapper.class);
	    job.setReducerClass(MaxTemperatureReducer.class);
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	}
	
	public boolean Process() throws ClassNotFoundException, IOException, InterruptedException
	{
		if(job!=null)
		{	
			return job.waitForCompletion(true);
		}
		return false;
	}
	
}

package com.dolan.hadoop.MapReduceDemo;

import org.apache.hadoop.mapreduce.Job;





/**
 * Hello world!
 *
 */
public class MaxTemperature 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        if(args.length != 2){
        	System.err.println("Usage:MaxTemperature <input path> <output path>");
        	System.exit(-1);
        }
        MaxTemperatureJob job = new MaxTemperatureJob(new String[]{args[0]},args[1]);
        System.exit(job.Process()?0:1);
    }
}

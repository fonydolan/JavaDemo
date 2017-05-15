package com.dolan.spark.GraphxDemo;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

public class SparkDemo {

	static final String SPARK_HOME = "D:/A_Fangqj/My_Server/hadoop";
	public void Process(){
		String logFile = String.format("{0}{1}",SPARK_HOME,"/README.md");
		SparkConf conf = new SparkConf().setAppName("SparkDemo");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> logData = sc.textFile(logFile).cache();
		
		long numAs = logData.filter(new Function<String, Boolean>() {
			public Boolean call(String s){ 
				return s.contains("a");
				}
		}).count();
		long numBs = logData.filter(new Function<String, Boolean>() {
			public Boolean call(String s) throws Exception {
				// TODO Auto-generated method stub
				return s.contains("b");
			}
		}).count();
		System.out.println(String.format("Lines with a:%f , Lines with b:%f",numAs,numBs));
		sc.stop();
	}
}

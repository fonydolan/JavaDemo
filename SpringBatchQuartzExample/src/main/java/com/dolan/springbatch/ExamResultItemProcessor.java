package com.dolan.springbatch;

import org.springframework.batch.item.ItemProcessor;

import com.dolan.springbatch.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult,ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing result:"+item);
		
		if(item == null || item.getPercentage() < 75){
			return null;
		}
		return item;
	}

	
}

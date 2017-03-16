package com.dolan.springbatch;

import org.springframework.batch.item.ItemProcessor;

import com.dolan.springbatch.model.ExamResult;

/*ItemProcessor is Optional, and called after item read but before item write. 
It gives us the opportunity to perform a business logic on each item.In our case, 
for example, we will filter out all the items whose percentage is less than 60.
So final result will only have records with percentage >= 60.*/
public class ExamResultItemProcessor implements ItemProcessor<ExamResult,ExamResult> {

	@Override
	public ExamResult process(ExamResult result) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing result:"+result);
		if(result != null && result.getPercentage() >= 60){
			return result;
		}
		return null;
	}

	
}

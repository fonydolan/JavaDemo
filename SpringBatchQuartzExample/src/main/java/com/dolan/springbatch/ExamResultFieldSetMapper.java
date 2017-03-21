package com.dolan.springbatch;

import org.joda.time.LocalDate;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.dolan.springbatch.model.ExamResult;

public class ExamResultFieldSetMapper implements FieldSetMapper<ExamResult> {

	@Override
	public ExamResult mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		ExamResult result;
		result = null;
		if(fieldSet!=null){
			result = new ExamResult();
			result.setStudentName(fieldSet.readString(0));
			result.setPercentage(fieldSet.readDouble(1));
			result.setDob(new LocalDate(fieldSet.readDate(2)));
		}
		return result;
	}
}

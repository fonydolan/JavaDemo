package com.dolan.springbatch;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.joda.time.LocalDate;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.dolan.springbatch.model.ExamResult;


//FieldSetMapper is responsible for mapping each field form the input to a domain object
public class ExamResultItemPreparedStatementSetter implements ItemPreparedStatementSetter<ExamResult> {
	
	@Override
	public void setValues(ExamResult item, PreparedStatement ps)
			throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(1, item.getStudentName());
		ps.setDate(2,new java.sql.Date(item.getDob().toDate().getTime()));
		ps.setDouble(3, item.getPercentage());
	}

}

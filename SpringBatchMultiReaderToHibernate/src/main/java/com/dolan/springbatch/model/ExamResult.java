package com.dolan.springbatch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;



@Entity
@Table(name="EXAM_RESULT")
public class ExamResult {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name="STUDENT_NAME",nullable=false)
	String studentName;
	
	@Column(name="DOB",nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	LocalDate dob;
	//Only special thing here is declaration of @Type which will 
	//help Hibernate easily map between jodatime LocalDate and database specific Date.
	
	@Column(name="PERCENTAGE",nullable=false)
	double percentage;
	
	public long getID(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getStudentName(){
		return studentName;
	}
	
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	
	public LocalDate getDob(){
		return dob;
	}
	
	public void setDob(LocalDate dob){
		this.dob = dob;
	}
	
	public double getPercentage(){
		return percentage;
	}
	
	public void setPercentage(double percentage){
		this.percentage = percentage;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(!(obj instanceof ExamResult)){
			return false;
		}
		ExamResult other = (ExamResult)obj;
		if(id != other.id){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "ExamResult[studentName="+studentName+",dob="+this.dob+",percentage="+percentage+"]";
	}
	
}

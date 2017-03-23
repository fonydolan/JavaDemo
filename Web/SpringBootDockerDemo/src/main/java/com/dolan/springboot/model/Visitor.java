package com.dolan.springboot.model;

import java.util.Date;

public class Visitor {
	String id;
	String ip;
	Date visitDate;
	
	public void setId(String id){
		this.id = id;
	}
	public void setIp(String ip){
		this.ip = ip;
	}
	public void setVisitDate(Date visitDate){
		this.visitDate = visitDate;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getIp(){
		return this.ip;
	}
	public Date getVisitDate(){
		return this.visitDate;
	}
	
}

package com.dolan.model.spittle;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {

	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public Spittle(String message,Date time,Double latitude,Double longitude){
		this.id=null;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Spittle(String message,Date time){
		this(message,time,null,null);
	}
	
	public long getID(){
		return this.id;
	}
	public String getMessage(){
		return this.message;
	}
	public Date getTime(){
		return this.time;
	}
	public Double getLatitude(){
		return this.latitude;
	}
	public Double getLongtitude(){
		return this.longitude;
	}
	
	@Override
	public boolean equals(Object that){
		return EqualsBuilder.reflectionEquals(this,that,"id","time");
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this, "id","time");
	}
	
	
}

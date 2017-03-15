package com.dolan.spring;

public class WelcomeHandler {
	
	Quest questWel;
	
	public WelcomeHandler(Quest questParam){
		questWel = questParam;
	}
	
	public void Say(){
		questWel.sayHello();
	}
	
}

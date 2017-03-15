package com.dolan.spring;

import org.springframework.stereotype.Component;


public class CatQuest implements Quest {
	
	@Override
	public void sayHello(){
		System.out.println("miao miao miao");
	}
}

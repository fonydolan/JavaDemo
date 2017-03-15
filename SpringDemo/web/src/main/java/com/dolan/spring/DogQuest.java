package com.dolan.spring;

import org.springframework.stereotype.Component;


@Component  //组件类   自动装配组件
public class DogQuest implements Quest{
	
	@Override
	public void sayHello(){
		System.out.println("wang wang wang");
	}
}

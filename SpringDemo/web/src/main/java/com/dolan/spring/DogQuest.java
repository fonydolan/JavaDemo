package com.dolan.spring;

import org.springframework.stereotype.Component;


@Component  //�����   �Զ�װ�����
public class DogQuest implements Quest{
	
	@Override
	public void sayHello(){
		System.out.println("wang wang wang");
	}
}

package com.dolan.study.demo;

import java.io.Serializable;

public class Person implements Cloneable,Serializable{

  public Person(){}

  public Person(String name,int age){
    setName(name);
    setAge(age);
  }

  private String name;
  
  public void setName(String name){
    this.name = name;
  }
  
  public String getName(){
    return this.name;
  }

  private int age;

  public void setAge(int age){
    this.age = age;
  }

  public int getAge(){
    return this.age;
  }

  
  public Person clone() throws CloneNotSupportedException{
    return (Person) super.clone();
  }
  
  public class Foot
  {
    public void work(){
      
    }
      
  }
  
}

package com.dolan.study.demo.proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {

  private Object target;
  
  public TraceHandler(Object t){
    target =t;
  }
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // TODO Auto-generated method stub
    return method.invoke(target, args);
  }

}

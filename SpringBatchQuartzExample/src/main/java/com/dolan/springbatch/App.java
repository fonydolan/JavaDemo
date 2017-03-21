package com.dolan.springbatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	@SuppressWarnings({ "unused", "resource" })
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" ); 
        ApplicationContext context = new ClassPathXmlApplicationContext("quartz-context.xml");
    }
}

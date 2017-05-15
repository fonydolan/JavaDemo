package com.dolan.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;



/** 
 * 是Spring Boot项目的核心注解,主要是开启自动配置 
 */  
@SpringBootApplication() // same as @Configuration @EnableAutoConfiguration @ComponentScan   
public class Application implements EmbeddedServletContainerCustomizer {
	

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
  
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// TODO Auto-generated method stub
		container.setPort(9099);
		
	}
	
}

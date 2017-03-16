package com.dolan.spring4.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;  

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.dolan.spring4")
public class WebConfig extends WebMvcConfigurerAdapter  {// extends WebMvcConfigurerAdapter 
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver;
		viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*
	无ViewResolver 没有配置视图解析器。如果这样的话，Spring默认会使用BeanNameView-Resolver，
	这个视图解析器会查找ID与视图名称匹配的bean，并且查找的bean要实现View接口，它以这样的方式来解析视图。
	
	无@ComponentScan 没有启用组件扫描。这样的结果就是，Spring只能找到显式声明在配置类中的控制器。
	
	这样配置的话，DispatcherServlet会映射为应用的默认
	Servlet，所以它会处理所有的请求，包括对静态资源的请求，如图片和样式表（在大多数情况下，这可能并不是你想要的效果）。
	*/
	
}

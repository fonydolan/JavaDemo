package com.dolan.spring4.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.dolan.spring4")
public class WebConfig {// extends WebMvcConfigurerAdapter 
	
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
	��ViewResolver û��������ͼ����������������Ļ���SpringĬ�ϻ�ʹ��BeanNameView-Resolver��
	�����ͼ�����������ID����ͼ����ƥ���bean�����Ҳ��ҵ�beanҪʵ��View�ӿڣ����������ķ�ʽ��������ͼ��
	
	��@ComponentScan û���������ɨ�衣�����Ľ�����ǣ�Springֻ���ҵ���ʽ�������������еĿ�������
	
	�������õĻ���DispatcherServlet��ӳ��ΪӦ�õ�Ĭ��
	Servlet���������ᴦ�����е����󣬰����Ծ�̬��Դ��������ͼƬ����ʽ���ڴ��������£�����ܲ���������Ҫ��Ч������
	*/

}

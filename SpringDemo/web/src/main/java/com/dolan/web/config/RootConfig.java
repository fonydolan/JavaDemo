package com.dolan.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"com.dolan.web"},
	excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
})//Ψһ��Ҫע�����RootConfigʹ����@ComponentScanע�⡣�����Ļ����ڱ����У����Ǿ��кܶ�����÷�Web���������ʵ����RootConfig��
public class RootConfig {

}

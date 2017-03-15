package com.dolan.spring4.restservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.dolan.spring4.restservice")
public class WebConfig {
	//Here this class is mainly providing the component-scanning and annotation support.
	//Note that we don¡¯t have any view-resolvers configured as we don¡¯t need one in Rest case.
	
}

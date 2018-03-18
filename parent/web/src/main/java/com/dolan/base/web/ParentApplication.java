package com.dolan.base.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dolan.base"})
@EnableAutoConfiguration
@MapperScan("com.dolan.base.*.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class ParentApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParentApplication.class, args);
	}
}

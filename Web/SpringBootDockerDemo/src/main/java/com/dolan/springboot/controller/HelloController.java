package com.dolan.springboot.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolan.springboot.model.Visitor;
import com.dolan.springboot.repository.VisitRepository;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Resource
	VisitRepository visitRepository;
	  
    @RequestMapping("")
	public String hello(HttpServletRequest request){
    	Visitor visitor = new Visitor();
    	visitor.setId(UUID.randomUUID().toString());
    	String ip = request.getRemoteAddr().toString();
    	visitor.setIp(ip);
    	visitor.setVisitDate(new Date());
    	visitRepository.save(visitor);
    	Long count = visitRepository.count();
	    return  String.format("你是来自%s的第%d位访问者。",ip,count);
	}
}

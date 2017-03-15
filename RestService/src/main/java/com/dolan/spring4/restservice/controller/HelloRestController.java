package com.dolan.spring4.restservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolan.spring4.restservice.domain.Message;

@RestController
//@RestController annotation, which marks this class as a controller where every method returns a domain object/pojo instead of a view.
public class HelloRestController {
	
	static final String HELLOWELCOME="Welcome to Rest Controller";
	static final String FORMAT_TWO="{0}{1}";
	
	@RequestMapping("/")
	public String welcome(){//Welcome page ,non-rest
		return HELLOWELCOME;
	}
	
	@RequestMapping("/hi/{player}")
	//@PathVariable indicates that this parameter will be bound to variable in URI template. 
	public Message message(@PathVariable String player){//Rest Endpoint
		Message msg;
		msg = new Message(player,FORMAT_TWO.format(HELLOWELCOME,player));
		return msg;
	}
	
}

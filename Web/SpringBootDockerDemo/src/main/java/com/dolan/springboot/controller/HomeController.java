package com.dolan.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("/")
    public String greeting() {
        return "Application go!";
    }
	
}

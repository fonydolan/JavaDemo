package com.dolan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by fangqj on 2016/12/28.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static  final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/index")
    public  String index()
    {
        logger.info("the home/index page");
        return "index";
    }

}

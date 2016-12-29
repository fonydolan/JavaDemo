package com.dolan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by fangqj on 2016/12/28.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static  final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/index")
    public  ModelAndView index()
    {
        logger.info("the Home/index page");
        return new ModelAndView("Home/index");
    }

}

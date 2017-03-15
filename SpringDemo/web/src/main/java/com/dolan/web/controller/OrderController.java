package com.dolan.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * Created by fangqj on 2017/1/10.
 */
@RequestMapping("/Order")
@RestController
public class OrderController {

    @RequestMapping("/List")
    public ModelAndView List()
    {
        return new ModelAndView("Order/List");
    }




}

package com.dolan.web.controller;

import com.dolan.iservice.IEngineerService;
import com.dolan.iservice.ITrafficTypeService;
import com.dolan.service.EngineerCommonService;
import com.dolan.service.TrafficTypeSubWayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fangqj on 2016/12/29.
 */
@Controller
@RequestMapping("/Engineer")
public class EngineerController {

    @RequestMapping("/Work")
    public String Work()
    {
        ITrafficTypeService iTrafficTypeService = new TrafficTypeSubWayService();
        IEngineerService iEngineerService = new EngineerCommonService("吕洞宾",iTrafficTypeService);
        return  iEngineerService.goToWork();
    }


}

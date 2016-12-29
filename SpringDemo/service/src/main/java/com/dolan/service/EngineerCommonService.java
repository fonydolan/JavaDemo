package com.dolan.service;

import com.dolan.iservice.IEngineerService;
import com.dolan.iservice.ITrafficTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

/**
 * Created by fangqj on 2016/12/29.
 */
@Service
public class EngineerCommonService implements IEngineerService {

    private static  final Logger logger = LoggerFactory.getLogger(EngineerCommonService.class);

    private ITrafficTypeService trafficType;

    private String name;

    public  EngineerCommonService(String name,ITrafficTypeService iTrafficTypeService)
    {
        name = name;
        trafficType = iTrafficTypeService;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String goToWork() {
        String msg =String.format("这是{0}；{1}去上班；",getName(),trafficType.trafficType());
        logger.info(msg);
        return msg;
    }
}

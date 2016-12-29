package com.dolan.service;

import com.dolan.iservice.IEngineerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fangqj on 2016/12/29.
 */
public class EngineerZhangeService implements IEngineerService {

    private static  final Logger logger = LoggerFactory.getLogger(EngineerZhangeService.class);
    @Override
    public String getName() {
        return "张天师";
    }

    @Override
    public String goToWork() {
        String msg =String.format("我是{0}！骑驴上班",getName());
        logger.info(msg);
        return  msg;
    }
}

package com.dolan.service;

import com.dolan.iservice.ITrafficTypeService;

/**
 * Created by fangqj on 2016/12/29.
 */
public class TrafficTypeSubWayService implements ITrafficTypeService {
    @Override
    public String trafficType() {
        return "乘坐地铁";
    }
}

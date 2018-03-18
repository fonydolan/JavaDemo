package com.dolan.study.demo;

import com.dolan.study.demo.effective.createobj.NutritionFacts;

/**
 * Created by Administrator on 2017/7/11.
 */
public class TestEffective {
    public void go(){
        NutritionFacts a = new NutritionFacts.Builder(1,1).fat(12).calories(1231)
                .sodium(45).build();
    }
}

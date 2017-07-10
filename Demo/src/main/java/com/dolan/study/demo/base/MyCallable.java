package com.dolan.study.demo.base;

import com.dolan.study.demo.Person;

import java.util.concurrent.Callable;

/**
 * Created by fangqj on 2017/7/10.
 */
public class MyCallable implements Callable<Person> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override public Person call() throws Exception {
        return null;
    }
}

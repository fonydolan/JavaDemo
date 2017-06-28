package com.dolan.study.demo.base;

/**
 * Created by fangqj on 2017/6/28.
 */
public class ThreadDemo {

    public void main() throws InterruptedException {
        Thread th = new Thread();
        th.run();
        th.interrupt();
        Thread.currentThread().isInterrupted();//不修改中断状态
        Thread.interrupted();//当前线程是否中断，将当前线程的中断状态重置为false
        th.join();//InterruptedException
        // 线程状态
       //New Runnable Blocked Waiting Timed waiting  Terminated
        th.getState();
        //抢占调度（Pc）  协作式调度（小设备 手机）  时间片机制调度器

        //优先级
        //MIN_PRIORITY-1  MAX_PRIORITY-10 NORM_PRIORITY-5

        //守护线程  线程启动前调用
        th.setDaemon(true);

        //未捕获异常处理器
        //线程run方法不能抛出任何被检测的异常  但会终止
        //异常会在线程死前 传递到一个用于未捕获异常的处理器
        //处理器属于一个实现Thread.UncaughtExceptionHandler接口的类 只有一方法uncaughtException
        //为所有线程加默认未捕获异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override public void uncaughtException(Thread t, Throwable e) {

            }
        });
        //单独指定
        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override public void uncaughtException(Thread t, Throwable e) {

            }
        });

        //无默认 无指定 用该线程的ThreadGroup对象做处理器




    }

    public void Sync(){

    }

}

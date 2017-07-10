package com.dolan.study.demo.base;

/**
 * Created by fangqj on 2017/7/10.
 */
public class ThreadRunnable implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override public void run() {
        try {
            //单独线程执行的代码
            while(!Thread.currentThread().isInterrupted()){//isInterrupted检测实例线程是否中断 不清除中断状态
                //do more
            }
            Thread.interrupted();//interrupted检测当前线程是否中断，且清除中断状态
        }
        //catch (InterruptedException e){}
        finally {

        }
    }
}

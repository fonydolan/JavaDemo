package com.dolan.study.demo.base;

import sun.nio.ch.ThreadPool;

import java.io.File;
import java.util.concurrent.*;

/**
 * Created by fangqj on 2017/7/10.
 */
public class ThreadDemo {
    public void go(){
        ThreadRunnable demoRun = new ThreadRunnable();
        Thread threadDemo = new Thread(demoRun);
        threadDemo.start();

        //thread stop 早期版本使用，已弃用
        //thread interrupt调用后 线程的中断状态将被置位。每个线程都有的Boolean标志
        //判断当前线程是否中断置位
        //现场阻塞时sleep/wait，会抛出InterruptedException
        Thread.currentThread().isInterrupted();

        //优先级 1~10
        threadDemo.setPriority(Thread.MAX_PRIORITY);
        //守护进程：唯一用途 为其他线程提供服务。计时线程
        Thread threadDaemon = new Thread(demoRun);
        threadDaemon.setDaemon(true);
        threadDaemon.start();

        //异常处理  默认一场处理器实现Thread.UncaughtExceptionHandler
        //线程中run不抛出未catch异常，不被检测异常导致线程终止，即死亡。死亡前将异常传给异常处理器。
        //为所有线程安装默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override public void uncaughtException(Thread t, Throwable e) {
                //异常处理
            }
        });
        //ThreadGroup 不设置默认异常处理器的时候 以ThreadGroup处理

        //执行器
        ExecutorService pool = Executors.newCachedThreadPool();
        String directoryPath = "";
        MathCounter counter = new MathCounter(new File(directoryPath),"hel",pool);
        Future<Integer> result = pool.submit(counter);
        try{
            System.out.println(result.get()+" matching files ");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {

        }
        pool.shutdown();
        int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
        System.out.println("largest pool size="+largestPoolSize);
        //同步器
        //允许线程等待直至其中预定数目的线程到达公共障栅barrier，然后选择一个处理障栅的动作
        CyclicBarrier cyclicBarrier = new CyclicBarrier( 10);
        //线程等待至计数器减为0
        CountDownLatch countDownLatch = new CountDownLatch(100);
        //允许两个线程在交换的对象准备好事交换对象
        Exchanger exchanger;
        //等待至线程被允许继续执行
        Semaphore semaphore;
        //允许线程将对象交给另一个
        SynchronousQueue<Integer> synchronousQueue;

        //信号量 一个管多个 许可证permits
        //信号量 同步原语

        //倒计时门栓CountDownLatch


    }




}



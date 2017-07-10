package com.dolan.study.demo.base;

import com.dolan.study.demo.Person;

import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by fangqj on 2017/6/29.
 */
public class SyncBankDemo {

    private final  double[] balance;

    //锁对象
    private ReentrantLock lock ;
    //条件对象
    private Condition tranferCondition;

    public SyncBankDemo(int n,double defaultBalance){
        balance = new double[n];
        for(int i=0;i<n;i++){
            balance[i] = defaultBalance;
        }
        lock = new ReentrantLock();
        tranferCondition = lock.newCondition();
    }
    //
    public double getBalance(int i){
        return balance[i];
    }
    //Condition ReentrantLock
    public void transfer(int from ,int to,double amount){
        lock.lock();
        try
        {
            while(balance[from]<amount) {
                tranferCondition.await();//当前线程限制被阻塞，并放弃锁；使得其他线程可以增加余额
                //await 进入该条件等待集 直到另一线程调用同一条件上的signalAll方法才解除
            }
            balance[from]-=amount;
            balance[to]+=amount;
            //完成转帐
            tranferCondition.signalAll();//重新激活同一条件阻塞的所有线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    //synchronized 内部锁 锁对象
    public synchronized void transfer2(int from ,int to,double amount){
        lock.lock();
        try
        {
            while(balance[from]<amount) {
                wait();//当前线程限制被阻塞，并放弃锁；使得其他线程可以增加余额
                //await 进入该条件等待集 直到另一线程调用同一条件上的signalAll方法才解除
            }
            balance[from]-=amount;
            balance[to]+=amount;
            //完成转帐
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private Object obj = new Object();
    //synchronized 2 使用一个对象的锁实现额外的原子操作，称客户端锁定
    //通常不推荐
    public synchronized void transfer3(int from ,int to,double amount){

        synchronized(obj) {
            balance[from] -= amount;
            balance[to] += amount;
        }

    }

    //监视器概念 monitor
    //Volatile 同步免锁机制
    public void Test() throws InterruptedException {
        //获取锁 成功true
        if(lock.tryLock(10, TimeUnit.MINUTES)){

        }
        lock.lockInterruptibly();//获取锁 超时为无限

    }
    //读写锁
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private Lock readlock = rwlock.readLock();
    private Lock writelock = rwlock.writeLock();

    public  int getNumber(){
        readlock.lock();
        try{}
        finally {
            readlock.unlock();
        }
        return 0;
    }
    public void setNumber(int number){
        writelock.lock();
        try
        {
        }
        finally {
            writelock.unlock();
        }
    }

    //stop suspend resue
    //stop 天生不安全，强行中断所有未结束方法，会导致处理一半而使得对象不一致
    //suspend不破坏对象
    public  void Test3(){

        BlockingQueue<Person> bqP = new PriorityBlockingQueue<>();
        bqP = new LinkedBlockingQueue<>();
        BlockingDeque<Person> bdP = new LinkedBlockingDeque<>();

    }

    public void ThreadSafe()
    {
        ConcurrentHashMap<String,Person> conMap = new ConcurrentHashMap<>();
        ConcurrentSkipListMap<String,Person> conLMap = new ConcurrentSkipListMap<>();
        ConcurrentSkipListSet<Person> pSet = new ConcurrentSkipListSet<>();
        ConcurrentLinkedQueue<Person> pLQueue = new ConcurrentLinkedQueue<>();



    }

}

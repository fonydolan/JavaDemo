package com.dolan.study.demo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.jar.JarInputStream;

import javax.swing.*;

import com.dolan.study.demo.events.TimerEvent;
import com.dolan.study.demo.jframe.SimpleFrame;
import com.dolan.study.demo.proxys.TraceHandler;
import com.dolan.study.demo.streams.FileDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, CloneNotSupportedException
    {
        System.out.println( "Hello World!" );
        System.out.println( System.getProperty("user.dir"));
        System.out.println( System.getProperties());

        FileDemo fileDemo = new FileDemo();
        try {
            fileDemo.go();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar deadline = new GregorianCalendar(2099,Calendar.DECEMBER,31);
        
        Scanner in = new Scanner(System.in);
        Class cl = Class.forName("com.dolan.study.demo.Person");
        cl.getSuperclass();
        Modifier.toString(cl.getModifiers());
        Constructor[] constructors = cl.getDeclaredConstructors();
        for(Constructor c :constructors){
          c.getName();
          Class[] paramTypes = c.getParameterTypes();
          //paramTypes[0].getName();
        }
        cl.getDeclaredMethods();
        cl.getDeclaredFields();
        
        Person p = new Person();
        p.setName("233");
        Person pCopy = p;
        pCopy.setName("455");
        Person pClone = p.clone();
        */
        ActionListener trE = new TimerEvent();
        Timer t = new Timer(10000,trE);
        t.start();
        
        Object value ="";
        TraceHandler trHandler = new TraceHandler(value);
        Class[] interfaces = new Class[]{Comparable.class};
        Object proxy = Proxy.newProxyInstance(null, interfaces, trHandler);
        System.out.println(proxy);
        
        EventQueue.invokeLater(new Runnable() {
          
          @Override
          public void run() {
            SimpleFrame frame;
            frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
          }
        });
        

        Throwable throwE = new Throwable();
        StackTraceElement[] stEles = throwE.getStackTrace();
        for(StackTraceElement stEle : stEles){
          System.out.println(stEle);
        }
        
        Dictionary<Integer,String> tabs = new Hashtable<>();
        JSlider jSl = new JSlider();
        tabs.put(11, "ojife");
        tabs.put(12, "kiofaw");
        jSl.setLabelTable(tabs);//泛型警告  Integer key 约束打破，专为String
        @SuppressWarnings("unchecked")//注释 用于取消代码检查
        Dictionary<Integer,String> tabsGet = jSl.getLabelTable();
        Calendar[] calendars = null;
        TUtils.min(calendars);
        TUtils.minSuper(calendars);
        TUtils.minNo(calendars);
        GregorianCalendar[] gCalendars=null;
        //TUtils.min(gCalendars);//无效GregorianCalendar中没有实现Comparable的compareTo(GregorianCalendar)方法
        TUtils.minSuper(gCalendars);
        TUtils.minNo(gCalendars);
        //队列 Queue
        Queue<String> qStr = new LinkedBlockingDeque<String>();
        //集合Collection add iterator ArrayList 迭代有序  HashSet 迭代无序
        //集合Map
        //ArrayList LinkedList ArrayDeque HashSet TreeSet EnumSet LinkedHashSet 
        //PriorityQueue HashMap TreeMap EnumMap LinkedHashMap WeakHashMap IdentityHashMap
        //链表  ArrayList LinkedList  java 中所有链表都是双向连接
        
        
    }
    public static class TUtils{
      
      public static <T extends Comparable<T>> T min(T[] a){
        return null;
      }
      
      public static <T extends Comparable<? super T>> T minSuper(T[] a){
        return null;
      }
      
      public static <T extends Comparable> T minNo(T[] a){
        return null;
      }
    }
    
}

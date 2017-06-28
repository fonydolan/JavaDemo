package com.dolan.study.demo.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.BitSet;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import java.util.Properties;

import com.dolan.study.demo.Person;

public class CollectionExtraDemo {
  void main() throws IOException{
    //遗留集合
    //Hashtable 与Vector一样  是同步的
    //遗留集合使用Enumeration进行遍历
    Hashtable ht = new Hashtable<String, Person>();
    Enumeration<Person> ePerson = ht.elements();
    if(ePerson.hasMoreElements()){
      ePerson.nextElement();
    }
    

    //属性映射表 Properties
    List<InputStream> streams = new ArrayList<>();
    SequenceInputStream in = new SequenceInputStream(Collections.enumeration(streams));
    Properties props = new Properties();
    props.load(in);
    props.getProperty("key");
    OutputStream out;
    //props.store(out, "out store");
    
    //栈Stack 扩展了Vector
    //push pop peek
    
    //位集 BitSet
    BitSet bs = new BitSet(10);
    bs.get(2);
    bs.set(3);//设置开
    bs.clear(3);//设置关
    

    BitSet bs2 = new BitSet(5);
    bs.and(bs2);
    bs.or(bs2);
    bs.xor(bs2);
    bs.andNot(bs2);
    
    //素数查找 Eratosthenes 筛子  最早发现用来枚举基本数字的方法之一
    //一个200万位的位集，初始全开。非素数位关闭
    
    
    
    
  }
}

package com.dolan.base.types;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionStudy {
	

	Hashtable<String,String> ht;//线程安全
	HashMap<String,String> hm;//线程不安全 一把 锁技术
	ConcurrentHashMap<String,String> chm;//线程安全 锁分段技术   key hashcode hash后的值valueKey高位进行分段-segment；segment中根据valueKey存储 hashentry
	//两种锁机制 Syncronized ReentrantLock(轮询锁，可中断锁等候，定时锁等候；需要finally释放)
	
	
	public CollectionStudy()
	{
		  
		
	}
	
	
}

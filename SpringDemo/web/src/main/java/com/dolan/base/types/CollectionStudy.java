package com.dolan.base.types;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionStudy {
	

	Hashtable<String,String> ht;//�̰߳�ȫ
	HashMap<String,String> hm;//�̲߳���ȫ һ�� ������
	ConcurrentHashMap<String,String> chm;//�̰߳�ȫ ���ֶμ���   key hashcode hash���ֵvalueKey��λ���зֶ�-segment��segment�и���valueKey�洢 hashentry
	//���������� Syncronized ReentrantLock(��ѯ�������ж����Ⱥ򣬶�ʱ���Ⱥ���Ҫfinally�ͷ�)
	
	
	public CollectionStudy()
	{
		  
		
	}
	
	
}

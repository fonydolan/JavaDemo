package com.dolan.study.demo.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AlgorithmDemo {
  void main(){

    String[] strArray = new String[10];
    List<String> strArrayList = Arrays.asList(strArray);
    //排序
    Collections.sort(strArrayList);
    Collections.sort(strArrayList,Collections.reverseOrder());//降序
    Comparator itemComp = new Comparator<String>(){
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    };
    Collections.sort(strArrayList,itemComp);
    Collections.sort(strArrayList,Collections.reverseOrder(itemComp));//逆序
    //sort 元素拷贝入数组进行排序（使用一种归并排序的变种），而后拷贝回list，sort数组必须可修改，但不必要可调大小
    //归并排序比快速慢，快速排序通用排序的传统选择。但归并稳定对象同元素不交换。
    
    //混乱序
    //shuffle 如果list未实现RandomAccess接口，打乱为先复制元素到数组 打乱数组元素顺序，而后赋列表
    Collections.shuffle(strArrayList);
    
    //二分查找
    //中间比较 大前查 小后查；迭代如是
    //strArrayList必须排过序
    int index = Collections.binarySearch(strArrayList, "11");
    //index>=0表示索引 小于0表示元素插入位置（-i-1）
    //java3 如果传入类扩展了AbstractSequentialList，自动变为线性查找，否则用二分查找
    //java4+ 如果传入类实现了RandomAccess接口，采用二分查找；否则采用线性查找
    
    //max min copy fill addAll replaceAll indexOfSubList lastIndexOfSubList
    //swap reverse rotate  
    //java 5.0 frequency统计和参数相同元素数量     disjoint比较两个集合有无共同元素
    
    
    
    
    
  }
}

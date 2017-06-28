package com.dolan.study.demo.base;

import com.dolan.study.demo.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by fangqj on 2017/6/26.
 */
public class CollectionFrameworkDemo {
    public void main(){
        //
        //Iterable--Collection--List,Set,Queue
        //Set--SortedSet--NavigableSet
        //Queue--Deque
        //
        //Map--SortedMap--NavigableMap
        //Iterator--ListIterator
        //RandomAccess

        //RandomAccess java4 add 标记接口
        //检测特定集合是否支持高效的随机访问
        //ArrayList和Vector实现了RandomAccess接口
        List<String> c = new ArrayList<>();
        if(c instanceof RandomAccess){
            //use random access algorithm
        }else{
            //use sequential access algorithm
        }

        //AbstractCollection--AbstractList,AbstractSet,AbstractQueue,ArrayDeque
        //AbstractList--AbstractSequentialList--LinkedList
        //AbstractList--ArrayList
        //AbstractSet--HashSet,TreeSet
        //AbstractQueue--PriorityQueue

        //AbstractMap--HashMap,TreeMap


        //其它容器
        //Vector,Stack,Hashtable,Properties

        //视图 包装器
        //视图：通过视图可以获得其它的实现了集合接口和映射表接口的对象。映射表的keySet就是这个示例，看似建立了新集，
        //而后将所有键填入。实际却不是，keySet返回一个实现了集Set接口的类对象，这个类的方法对原映射表进行操作。这种
        //集合称视图。

        //轻量级集包装器
        Person [] pArrays = new Person[10];
        List<Person> pList = Arrays.asList(pArrays);//返回的不是ArrayList。是一个视图对象。带有底层数组的get和
        //set方法。改变数组大小的所有方法都会抛出Unsupported OperationException异常
        //java5后
        List<String> name=Arrays.asList("cat1","cat2","cat3");
        Person person = new Person("cat4",15);
        //创建一个包含10个字符串的List，每个设置为hello 字符串只存储一次，代价很小
        List<String> personList = Collections.nCopies(10,"hello");//返回视图
        Set<String> strSet = Collections.singleton("world");//返回视图
        List<String> strList = Collections.singletonList("world");//返回视图
        Map<Integer,String> strMap = Collections.singletonMap(109,"world");//返回视图
        //返回视图 不需要建立数据结构的开销

        //子范围 视图
        List<String> stringList = new ArrayList<>();
        List group2 =stringList.subList(10,20);//返回10~19个元素 参数1包含，参数2不包含与substring雷同
        //子范围 可以操作并反映于列表中
        group2.clear();//元素从group2删除 且list中也删除

        //有序集和映射表 可通过排序顺序而非元素位置建立子范围
       /* SortedSet<String> sortedSet ;
        sortedSet = 
        sortedSet.subSet("1","2");//from to
        sortedSet.headSet("2");//to
        sortedSet.tailSet("1");//from
        */
        //SortedMap雷同
        //java6 NavigableSet雷同

        //不可修改的视图
        /* Collections中6个不可修改视图返回
        //unmodifiableCollection，synchronizedCollection和checkedCollection一样都返回一个集合，其equals不调用底层equals
        //而是使用Object的equals，即只检测两个对象是否同一对象
         //unmodifiableList和unmodifiableSet使用底层equals
        Collections.unmodifiableCollection();
        Collections.unmodifiableList()
        Collections.unmodifiableSet()
        Collections.unmodifiableMap()
        Collections.unmodifiableSortedSet()
        Collections.unmodifiableSortedMap()
        * */
        List<String> staff = new LinkedList<>();
        //lookAt(Collections.unmodifiableList(staff));

        //同步视图
        //使用视图机制来实现线程安全
        Map<String,Person> map = Collections.synchronizedMap(new HashMap<String, Person>());
        
        //错误元素
        ArrayList<String> stringArray = new ArrayList<String>();
        ArrayList stringArray1 = stringArray;
        stringArray1.add(new Date());//add检测通过，只会在get时候将结果转string，这时才抛出异常
        //检测
        List<String> checkedList = Collections.checkedList(stringArray1, String.class);
        //checkedList 的add方法在添加非String时 抛出ClassCastException
        //对于Pair<String> 插入Pair<Date>无法检测
        List<String> defaultStrings = Collections.nCopies(10, "default");
        Set<String> singletonList = Collections.singleton("default");
        String[] strArray = new String[10];
        List<String> strArrayList = Arrays.asList(strArray);
        //strArrayList可修改 但大小不可变
        
        //批操作
        Set<String> strSetBatch1 = new HashSet(){};
        strSetBatch1.add("a");
        strSetBatch1.add("b");
        strSetBatch1.add("c");
        strSetBatch1.add("d");
        Set<String> strSetBatch2 = new HashSet(){};
        strSetBatch2.add("b");
        strSetBatch2.add("c");
        Set<String> strSetBatch =new HashSet<String>(strSetBatch1);
        strSetBatch.retainAll(strSetBatch2);
        //strSetBatch保存strSetBatch1和strSetBatch2的交集
        
        //集合/数组转
        String[] values=new String[]{"1","2","3","4"};
        HashSet<String> strSetTran = new HashSet<>(Arrays.asList(values));
        
        Object[] strArrayObj = strSetTran.toArray();
        String[] valuesTran = (String[])strSetTran.toArray(); //Error toArray返回的对象数组无法改变类型
        //toArray 双重职责 填充已有的数组（如果足够长），创建一个新数组
        valuesTran = strSetTran.toArray(new String[0]);//创建
        valuesTran = strSetTran.toArray(new String[strSetTran.size()]);//不创建任何新数组
        
        
        
        
        
        
        
    }

}

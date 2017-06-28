package com.dolan.study.demo.base;

import com.dolan.study.demo.Person;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LinkedList;
import java.lang.String;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionDemo {
  public void forList(){
    //一：链表 自定义元素排序
    List<String> staff = new LinkedList<String>();
    staff.add("fqj1");
    staff.add("fqj2");
    staff.add("fqj3");
    Iterator iter = staff.iterator();
    String first = (String) iter.next();

    //set->设置next/previous返回的上一个元素
    ListIterator<String> iterList = staff.listIterator();
    String oldValue = iterList.next();
    iterList.set("fqjset1");

    //两个迭代器同时访问，其中一个修改了之后，另一个访问会抛出concurrent modificationexception
    ListIterator<String> iterList1 = staff.listIterator();
    ListIterator<String> iterList2 = staff.listIterator();
    iterList1.next();
    iterList1.remove();
    iterList2.next();//throws ConcurrentModificationException

    //get index need to go elements before index

    //二：数组  自定义元素排序
    //List元素访问协议：1。迭代器 2。get/set方法随机访问每个元素
    //ArrayList 封装了一个动态再分配的对象数组 非同步。非线程安全
    //动态数组另一种：Vector 同步，线程安全

    //三：散列集  hash
    //散列表 hashtable java中以链表数组实现 每个列表称桶bucket
    //再散列 装填因子
    //hashset
    Set<String> words = new HashSet<>();
    words.add("hello");
    words.add("my");
    words.add("world");
    words.add("!");

    //四：树集 TreeSet 有序集合 排序（红黑树）《introduction to algorithms》 thomas cormen...
    SortedSet<Person> sortedSet1;
    TreeSet<Person> sortedSet = new TreeSet<>(new Comparator<Person>() {
      @Override public int compare(Person o1, Person o2) {
         return o1.getName().compareTo(o2.getName());
      }
    });
    //1.6 add TreeSet实现NavigableSet接口
    //sortedSet.ceiling() higer lower ceiling 大于的最小元素 floor 小于的最大元素
    //pollFirst 大于等于的最小元素 pollLast 小于等于得最大元素    没有返回null
    //descendingIterator 发挥递减顺序遍历元素的迭代器

    //五：队列  双端队列  头/尾部 添加删除
    //java 5
    //添加  add队满throws IllegalStateException  offer 队满false
    //删除并返回 remove队空 throws NoSuchElementException poll队空返回null
    //返回但不删除 element队空throws NoSuchElementExcetpion  peek队空null

    //java6  引入Depue接口  ArrayDeque和LinkedList实现，都提供了双端队列
    //Deque
    //addFirst addLast 队满throws IllegalStateException
    //offerFirst offerLast 队满返回false
    //removeFirst removeLast
    //pollFirst pollLast
    //getFirst getLast
    //peekFirst peekLast
    //ArrayDeque 构造初始容量默认16的无限双端队列

    //六.优先级队列 priority queue
    //元素按任意顺序插入，但按排序顺序检索。也就是无论何时调remove，总获取当前优先级队列中最小的元素，
    //但优先级队列并没有对所有元素排序。
    //使用数据结构：堆heap  一个可以自我调整的二叉树，对树添加/删除可让最小元素移动到根
    //典型示例：任务调度
    PriorityQueue<Person> personQueue = new PriorityQueue<>();
    personQueue.add(new Person("hehua",12));
    personQueue.add(new Person("lanhua",19));
    personQueue.add(new Person("baichahua",24));

    System.out.println(personQueue.remove().getName());

    //七.映射表 map 键值对
    //java HashMap  TreeMap
    Map<String,Person> stringPersonMap = new HashMap<>();
    stringPersonMap.put("fjiwo",new Person("lantian",26));
    Person pMapGet = stringPersonMap.get("fjiwo");
    //集合视图 键集 值集合（不是集）和键值对集。
    //Set<K> keySet; Collection<K> values() Set<Map.Entry<K,V>> entrySet()
    //Map
    //put  key value  key可以null，value不可以null
    //HashMap
    //构造传入装填因子 默认0.75  reset执行的容量百分比
    //TreaMap
    //SortedMap

    //八：专用集合映射表类
    //弱散列映射表 WeakHashMap
    //若一个值对应键已不再使用。WeakHashMap使用弱引用保存键。垃圾回收器发现某对象已经没有他人引用 就将其回收。
    //

    //链接散列集合链接映射表 LinkedHashSet LinkedHashMap
    Map lhset = new LinkedHashMap();
    lhset.put("hehe",new Person("jow",123));
    lhset.keySet().iterator();
    lhset.values().iterator();
    //以访问顺序迭代，而非插入顺序  每次get/put，受影响条目从当前位置移除，插入条目链表尾部
    //访问顺序对实现高速缓存的最近最少使用原则十分重要。
    //自动删除 最少使用的条目
    Map<String,Person> cache = new LinkedHashMap<String,Person>(128,0.75F,true){
      protected boolean removeEldestEntry(Map.Entry<String,Person> eldest){
        return size()>100;
      }
    };

    //枚举集合映射表 EnumSet EnumMap
    EnumSet<WeekDays> always = EnumSet.allOf(WeekDays.class);
    EnumSet.noneOf(WeekDays.class);
    //range  of
    EnumMap<WeekDays,Person> personEnumMap = new EnumMap<>(WeekDays.class);

    //标识散列映射表 IdentityHashMap java4 add
    //散列值以System.identityHashCode计算 根据内存地址来计算散列值的方式 比较时IdentityHashMap使用==而不是equals
    //即不同键对象  即时内容相同 也被看为不同对象  对象遍历算法如对象序列化时候这个类非常有用。



  }
}

enum WeekDays{MONDY,TUESDAY,WEBNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};

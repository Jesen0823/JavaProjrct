package javabasereview.collectionsandmap;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Sorted接口就是用来排序的，TreeSet实现了SortedSet接口
 * */
public class SortedSetDemo5 {
    public static void main(String[] args) {
        SortedSet<TreeSetBean> allSet2 = new TreeSet<TreeSetBean>();
        allSet2.add(new TreeSetBean("北京",2009));
        allSet2.add(new TreeSetBean("成都",2008));
        allSet2.add(new TreeSetBean("大同",2010));
        allSet2.add(new TreeSetBean("广州",2003));
        allSet2.add(new TreeSetBean("杭州",2011));
        allSet2.add(new TreeSetBean("广州",2003));
        System.out.println(allSet2);
        System.out.println("第一个元素："+allSet2.first());
        System.out.println("最后一个元素："+allSet2.last());
        System.out.println("从开始到大同的元素集合："+allSet2.headSet(new TreeSetBean("大同",2010)));
        System.out.println("从大同到最后的元素集合："+allSet2.tailSet(new TreeSetBean("大同",2010)));
        System.out.println("大同到杭州的元素集合："+allSet2.subSet(
                new TreeSetBean("大同",2010),new TreeSetBean("杭州",2011)));


    }
}

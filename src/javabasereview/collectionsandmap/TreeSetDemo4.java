package javabasereview.collectionsandmap;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo4 {
    public static void main(String[] args) {
        Set<String> allSet = new TreeSet<String>();
        allSet.add("SA");
        allSet.add("SB");
        allSet.add("SC");
        allSet.add("SD");
        System.out.println(allSet);

        // 自定义一个类实现排序,这个类必须实现Comparable接口
        Set<TreeSetBean> allSet2 = new TreeSet<TreeSetBean>();
        allSet2.add(new TreeSetBean("北京",2009));
        allSet2.add(new TreeSetBean("成都",2008));
        allSet2.add(new TreeSetBean("大同",2010));
        allSet2.add(new TreeSetBean("广州",2003));
        allSet2.add(new TreeSetBean("杭州",2011));
        allSet2.add(new TreeSetBean("广州",2003));
        System.out.println(allSet2);
    }
}

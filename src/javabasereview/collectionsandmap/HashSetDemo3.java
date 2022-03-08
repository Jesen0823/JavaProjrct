package javabasereview.collectionsandmap;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo3 {
    public static void main(String[] args) {
        Set<String> allSet = new HashSet<String>();
        allSet.add("SA");
        allSet.add("SB");
        allSet.add("SC");
        allSet.add("SD");
        System.out.println(allSet);

        Set<TreeSetBean> allSet2 = new HashSet<TreeSetBean>();
        allSet2.add(new TreeSetBean("北京",2009));
        allSet2.add(new TreeSetBean("成都",2008));
        allSet2.add(new TreeSetBean("大同",2010));
        allSet2.add(new TreeSetBean("广州",2003));
        allSet2.add(new TreeSetBean("杭州",2011));
        allSet2.add(new TreeSetBean("广州",2003));
        // 广州重复了,Bean类需要重写equals()和hashCode()才能去掉重复元素
        System.out.println(allSet2);
    }
}

package javabasereview.collectionsandmap.iterator;

import javabasereview.ProUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("L1");
        list.add("L2");
        list.add("L3");
        list.add("L4");
        System.out.println("使用Iterator迭代：");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String ele = iterator.next();
            System.out.print(ele+",");
            // 删除元素
            if (ele.equals("L3")){
                iterator.remove();
            }
        }
        System.out.println("删除元素L3后："+list);

        ProUtil.printLine();

        System.out.println("使用ListIterator迭代：从前往后");
        ListIterator<String> iterator1 = list.listIterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        // 添加元素
        iterator1.add("LL");
        System.out.println("使用ListIterator迭代:从后往前");
        while (iterator1.hasPrevious()){
            String preEle = iterator1.previous();
            System.out.println(preEle);
            if (preEle.equals("L2")){
                iterator1.set("Lin");
            }
        }
        System.out.println("最终结果："+list);

    }
}

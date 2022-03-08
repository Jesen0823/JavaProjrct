package javabasereview.collectionsandmap;

import java.util.LinkedList;

/**
 * 链表操作
 * */
public class LinkedListDemo2 {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        link.add("l1");
        link.add("l2");
        link.addFirst("F");
        link.addLast("L");
        System.out.println("链表内容："+link);
        System.out.println("用element()找到表头："+link.element());
        System.out.println("链表内容："+link);
        System.out.println("用peek()找到表头："+link.peek());
        System.out.println("链表内容："+link);
        System.out.println("用poll()找到表头："+link.poll());
        System.out.println("链表内容："+link);
        System.out.println("使用poll取出第二个元素：");
        for (int i = 0; i < link.size()+1;i++){
                System.out.println(link.poll());
        }

    }
}

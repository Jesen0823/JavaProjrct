package javabasereview.collectionsandmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * List的子类之一
 * */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        List<String> allList = new ArrayList<String>();
        Collection<String> collection = new ArrayList<String>();

        allList.add("a1");
        allList.add("a2");
        allList.add(0,"a0");
        System.out.println("List: "+allList);
        collection.add("c1");
        collection.add("c2");
        System.out.println("collection: "+collection);
        allList.addAll(collection);
        System.out.println("List after addAll(collection): "+allList);
        allList.addAll(0,collection);
        System.out.println("List after addAll(0,collection): "+allList);
        allList.remove("c1");
        System.out.println("List 删除c1: "+allList);
        allList.remove(0);
        System.out.println("List 删除了第一个元素: "+allList);

        // 集合转变为对象数组
        String str[] = allList.toArray(new String[]{});
        System.out.println("集合转换为对象数组：");
        for (int i = 0; i < str.length;i++){
            System.out.print(str[i]+"，");
        }
        // 判断某元素是否存在
        System.out.println("\n a2 是否存在：" + allList.contains("a2"));
        System.out.println("a2元素的位置："+ allList.indexOf("a2"));
        System.out.println("集合是否为空："+ allList.isEmpty());
        List<String> subList = allList.subList(1,4);
        System.out.println("截取下标1-4作为子集合："+ subList);
    }
}

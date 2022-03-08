package javabasereview.collectionsandmap;

import java.util.*;

public class HashMapDemo6 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("北京",10);
        map.put("保定",12);
        map.put("常州",17);
        map.put("兰州",9);
        if (map.containsKey("北京")){
            System.out.println("取出北京："+map.get("北京"));
        }
        if (map.containsValue(17)){
            System.out.println("代号17存在");
        }

        System.out.println("准备取出全部的key,Set集合形式：-->");
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        System.out.println("\n准备取出全部的value,Collection集合形式：-->");
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }

        System.out.println("Map的标准迭代：-->");
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            Map.Entry<String, Integer> m = iterator2.next();
            System.out.print(m.getKey()+":"+m.getValue()+"\n");
        }

        System.out.println("Map的foreach迭代：-->");
        for (Map.Entry<String,Integer> m:map.entrySet()){
            System.out.print(m.getKey()+"="+m.getValue()+"\n");
        }

    }
}

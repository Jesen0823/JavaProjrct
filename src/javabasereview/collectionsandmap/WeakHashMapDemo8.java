package javabasereview.collectionsandmap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 弱引用集合，垃圾回收掉对象
 * 结果：前两个被回收
 * */
public class WeakHashMapDemo8 {
    public static void main(String[] args) {
        Map<String,String> map = new WeakHashMap<String, String>();
        map.put(new String("K1"),new String("V1"));
        map.put(new String("K2"),new String("V2"));
        map.put("K3","V3");
        map.put("K4","V4");
        System.gc();
        map.put("K5","V5");
        System.out.println(map);
    }
}

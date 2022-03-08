package javabasereview.collectionsandmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * TreeMap可以实现排序
 * */
public class TreeMapDemo7 {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<String, String>();
        map.put("Apple","red");
        map.put("Water","red");
        map.put("Orange","yellow");
        map.put("Pear","green");
        Set<String> keys = map.keySet();
        Iterator<String> iterable = keys.iterator();
        while (iterable.hasNext()){
            System.out.print(iterable.next()+" ");
        }
    }
}

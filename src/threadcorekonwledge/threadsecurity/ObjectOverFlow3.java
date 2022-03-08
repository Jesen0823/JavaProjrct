package threadcorekonwledge.threadsecurity;

import org.omg.CORBA.Object;

import java.util.HashMap;
import java.util.Map;

/**
 * 对象发布的溢出
 * */
public class ObjectOverFlow3 {
    private Map<String,String> stats;

    public ObjectOverFlow3(){
        stats = new HashMap<>();
        stats.put("1","天津");
        stats.put("2","海口");
        stats.put("3","福建");
    }

    public Map<String,String> getStats(){
        // 把private对象直接返回了，直接发布给外界调用了
        return stats;
    }

    public Map<String,String> rightGetStats(){
        // 返回一个新对象，防止调用者篡改
        return new HashMap<>(stats);
    }

    public static void main(String[] args) {
        ObjectOverFlow3 instance = new ObjectOverFlow3();
        Map<String,String> o1 = instance.getStats();
        System.out.println("first:"+o1.get("1"));
        o1.remove("1");
        System.out.println("second:"+o1.get("1"));
    }
}

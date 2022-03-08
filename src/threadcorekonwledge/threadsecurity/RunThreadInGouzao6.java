package threadcorekonwledge.threadsecurity;

import java.util.HashMap;
import java.util.Map;

/**
 * 在构造函数中新建线程
 * */
public class RunThreadInGouzao6 {
    private Map<String,String> stats;

    public RunThreadInGouzao6(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                stats = new HashMap<>();
                stats.put("1","天津");
                stats.put("2","海口");
                stats.put("3","福建");
            }
        }).start();
    }

    public Map<String,String> getStats(){
        return stats;
    }

    public static void main(String[] args) {
        RunThreadInGouzao6 instance = new RunThreadInGouzao6();
        Map<String,String> o1 = instance.getStats();
        System.out.println("first:"+o1.get("1"));
        o1.remove("1");
        System.out.println("second:"+o1.get("1"));
    }
}

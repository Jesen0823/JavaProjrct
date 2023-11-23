package design_patterns_2.struct.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 正如上文所说，享元模式通过消息池的形式有效地减少了重复对象的存在。它通过内部状态标
 * 识某个种类的对象，外部程序根据这个不会变化的内部状态从消息池中取出对象。使得同一类对象
 * 可以被复用，避免大量重复对象。
 */
public class TicketFactory {
    static Map<String,Ticket> mTicketMap = new ConcurrentHashMap<>();

    public static Ticket getTicket(String from, String to){
        String key = new StringBuilder(from).append("-").append(to).toString();
        if (mTicketMap.containsKey(key)){
            System.out.println("使用缓存 ===>"+key);
            return mTicketMap.get(key);
        }else {
            System.out.println("新创建对象");
            Ticket ticket = new TrainTicket(from,to);
            mTicketMap.put(key,ticket);
            return ticket;
        }
    }
}


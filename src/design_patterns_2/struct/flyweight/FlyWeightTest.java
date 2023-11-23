package design_patterns_2.struct.flyweight;
/**
 *  享元模式
 *
 *  Message.obtain()就是享元模式，Message有一个next，它的对象池是以链表形式存储的
 *  池的大小是50
 *
 *  享元模式是对象池的一种实现，它的英文名称叫做Flyweight，代表轻量级的意思。享元模式
 * 用来尽可能减少内存使用量，它适合用于可能存在大量重复对象的场景，来缓存可共享的对象，达
 * 到对象共享、避免创建过多对象的效果，这样一来就可以提升性能、避免内存移除等。
 *
 * 象容器，在经典的享元模式中该容器为一个Map，它的键是享元对象的内部状态，它的值就是享元
 * 对象本身。客户端程序通过这个内部状态从享元工厂中获取享元对象，如果有缓存则使用缓存对象，
 * 否则创建一个享元对象并且存入容器中，这样一来就避免了创建过多对象的问题。
 */
public class FlyWeightTest {
    public static void main(String[] args) {
        Ticket ticket1 = TicketFactory.getTicket("北京","西安");
        ticket1.showTicketInfo("硬座");
        Ticket ticket2 = TicketFactory.getTicket("北京","西安");
        ticket2.showTicketInfo("硬卧");
        Ticket ticket3 = TicketFactory.getTicket("北京","西安");
        ticket3.showTicketInfo("软卧");
        Ticket ticket4 = TicketFactory.getTicket("北京","西安");
        ticket4.showTicketInfo("一等座");
    }
}

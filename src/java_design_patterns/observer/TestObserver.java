package java_design_patterns.observer;

/**
 * 观察者模式：
 * <p>
 * 观察者模式又被称为发布-订阅模式，属于行为型设计模式的一种，是个在项目中经常使用的模式。
 * 定义：定义对象间一种一对多的依赖关系，每当一个对象改变状态时，则所有依赖于它的对象都会得到通知并被自动更新。
 * <p>
 * 事件多级触发场景。
 * 跨系统的消息交换场景，如消息队列、事件总线的处理机制。
 * <p>
 * ・优点：
 * 观察者和被观察者之间是抽象耦合，容易扩展。方便建立一套触发机制。
 * <p>
 * ·缺点：
 * 在应用观察者模式时需要考虑一下开发效率和运行效率的问题。程序中包括一个被观察者、多个观察者，开发、调试等内容会比较复
 * 杂，而且在Java中消息的通知一般是顺序执行的，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步方式。
 */
public class TestObserver {

    public static void main(String[] args) {
        // 被观察者
        SubscriptionSubject subject = new SubscriptionSubject();

        // 观察者们
        WeixinUser user1 = new WeixinUser("Jesen");
        WeixinUser user2 = new WeixinUser("SangLuo");
        WeixinUser user3 = new WeixinUser("Empty12");

        // 订阅
        subject.add(user1);
        subject.add(user2);
        subject.add(user3);

        subject.notify("公众号暂时停更几天，感谢各位假日愉快！");
    }
}

package design_patterns_2.action.observer;
/**
 * 观察者模式作用主要是对象解耦，将订阅者与被订阅者隔离
 * 观察者模式的应用：
 * ListView的adapter数据通知变化
 * EventBus总线
 * BroadcastReceiver广播通知
 * */
public class ObserverTest {

    public static void main(String[] args) {
        GoogleDoc google = new GoogleDoc();

        Coder coder1 = new Coder("John");
        Coder coder2 = new Coder("Jesen");
        Coder coder3 = new Coder("Pola");

        google.addObserver(coder1);
        google.addObserver(coder2);
        google.addObserver(coder3);

        google.publish("androidx-compose 1.6");
    }
}

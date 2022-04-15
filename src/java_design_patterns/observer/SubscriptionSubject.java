package java_design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者
 *
 * */
public class SubscriptionSubject implements Subject {

    // 存储已经订阅了的观察者列表，或者关注了微信公众号的用户
    private List<Observer> userList = new ArrayList<Observer>();

    @Override
    public void add(Observer observer) {
        if (!userList.contains(observer)){
            userList.add(observer);
        }
    }

    @Override
    public void remove(Observer observer) {
        if (userList.contains(observer)){
            userList.remove(observer);
        }
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : userList) {
            observer.update(msg);
        }
    }
}

package design_patterns_2.action.observer;

public class GoogleDoc extends Observable {

    public void publish(String content){
        notifyObservers(content);
    }
}

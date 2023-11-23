package design_patterns_2.action.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Observable {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer){
        if (observerList.contains(observer)){
            return;
        }
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
        if (observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    public void notifyObservers(Object object){
        if (observerList.size()>0){
            for(Observer o:observerList){
                o.update(this,object);
            }
        }
    }
}

package design_patterns_2.action.observer;

public class Coder implements Observer {

    public String name;

    public Coder(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+"悉知更新："+arg);
    }

    @Override
    public String toString() {
        return "Coder{" +
                "name='" + name + '\'' +
                '}';
    }
}

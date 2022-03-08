package javabasereview.reflect.factorymode;
/**
 * 工厂类
 * */
public class Factory {
    public static Fruit getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Fruit fruit = null;
        fruit = (Fruit) Class.forName(className).newInstance();
        return fruit;
    }
}

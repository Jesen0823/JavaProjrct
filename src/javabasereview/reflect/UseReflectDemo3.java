package javabasereview.reflect;
/**
 * 调用有参构造实例化对象
 * 可用getConstructors取得全部构造方法，再向构造方法传递参数
 * */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UseReflectDemo3 {
    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("javabasereview.reflect.Mountain");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Mountain m = null;
        Constructor<?> cons[] = c.getConstructors();
        // 向构造方法中传递参数，此方法可用可变参数接收并实例化对象
        try {
            m = (Mountain) cons[1].newInstance("印地安思山脉",3699);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(m);
    }
}

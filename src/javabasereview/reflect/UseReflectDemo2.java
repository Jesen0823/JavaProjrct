package javabasereview.reflect;
/**
 * 通过class对象用newInstance实例化一个类的对象，该类一定要保证存在无参构造方法
 * */
public class UseReflectDemo2 {
    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("javabasereview.reflect.Mountain");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Mountain m = null;
        try {
             m = (Mountain) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        m.setName("横断山脉");
        m.setAltitude(5442);
        System.out.println(m);

    }
}

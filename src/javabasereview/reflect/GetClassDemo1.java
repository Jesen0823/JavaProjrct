package javabasereview.reflect;
/**
 * 实例化class对象
 * */
public class GetClassDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = null;
        Class<?> c2 = null;
        Class<?> c3 = null;
        c1 = Class.forName("java.lang.Thread");
        c2 = new Thread().getClass();
        c3 = Thread.class;
        System.out.println("类名称："+c1.getName());
        System.out.println("类名称："+c2.getName());
        System.out.println("类名称："+c3.getName());
    }
}

package javabasereview.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 反射调用类中的方法
 * */
public class UseReflectDemo5 {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("javabasereview.reflect.Mountain");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 调用类中的无参方法
        try {
            Method method = clazz.getMethod("climb");
            method.invoke(clazz.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 调用类中的有参方法
        try {
            Method method2 = clazz.getMethod("isOver5000", String.class, int.class);
            boolean result = (boolean) method2.invoke(clazz.newInstance(), "乔哥里峰", 7488);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

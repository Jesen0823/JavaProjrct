package javabasereview.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射调用类中的get和set方法
 * */
public class UseReflectGetSet6 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = null;
        Object obj = null;
        try {
            clazz = Class.forName("javabasereview.reflect.Mountain");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        setter(obj, "name","太行山", String.class);
        setter(obj, "altitude",2882, int.class);
        System.out.println("山名：");
        getter(obj, "name");
        System.out.println("主峰海拔：");
        getter(obj, "altitude");
    }

    private static void getter(Object obj, String att) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getMethod("get"+toFirstUpper(att));
        System.out.println(method.invoke(obj));
    }

    private static void setter(Object obj, String str, Object value , Class<?> type) throws NoSuchMethodException {
        Method method = obj.getClass().getMethod("set"+toFirstUpper(str), type);
        try {
            method.invoke(obj, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 首字母大写转换
    private static String toFirstUpper(String source) {
        String str = source.substring(0,1).toUpperCase()+source.substring(1);
        return str;
    }

}

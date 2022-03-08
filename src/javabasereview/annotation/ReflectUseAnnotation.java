package javabasereview.annotation;

import java.lang.reflect.Method;
/**
 * 用反射取出注解的值
 * */
public class ReflectUseAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> c = null;
        c = Class.forName("javabasereview.annotation.UseMyAnnotation");
        Method method = c.getMethod("doSomething");
        if (method.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String param1 = myAnnotation.arg1().toString();
            String param2 = myAnnotation.arg2().name();
            System.out.println("arg1,arg2="+param1+", "+param2);
        }else {
            System.out.println("error.");
        }
    }
}


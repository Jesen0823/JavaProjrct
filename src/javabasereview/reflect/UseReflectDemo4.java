package javabasereview.reflect;

import javabasereview.ProUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 取得类实现的所有接口，方法，属性和父类
 */
public class UseReflectDemo4 {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("javabasereview.reflect.Mountain");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 1.取得全部接口
        Class<?> interfaces[] = clazz.getInterfaces();
        System.out.println("该类继承了接口：");
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i].getName());
        }

        // 2.取得父类
        Class<?> father = clazz.getSuperclass();
        ProUtil.printLine();
        System.out.println("\n 父类： "+ father.getName());
        ProUtil.printLine();
        // 3.取得类中的全部方法
        getAllMethod(clazz);
        ProUtil.printLine();
        // 4.取得类中的全部属性
        getAllFields(clazz);
    }

    @SuppressWarnings("unchecked")
    private static void getAllFields(Class<?> clazz) {
        Field fields[] = clazz.getDeclaredFields();
        System.out.println("本类属性：");
        for (int i = 0; i < fields.length; i++){
            Class<?> type = fields[i].getType();
            int mo = fields[i].getModifiers();
            System.out.print(Modifier.toString(mo) + " ");
            System.out.print(type.getName()+" ");
            System.out.println(fields[i].getName()+";");
        }

        Field fs[] = clazz.getFields();
        System.out.println("父类或接口属性：");
        for (int j = 0; j < fs.length; j++){
            Class<?> type = fs[j].getType();
            int mo = fs[j].getModifiers();
            System.out.print(Modifier.toString(mo) + " ");
            System.out.print(type.getName()+" ");
            System.out.println(fs[j].getName()+";");
        }
    }

    private static void getAllMethod(Class<?> clazz) {
        Method ms[] = clazz.getMethods();
        System.out.println("本类所有方法：");
        for (int i = 0;i<ms.length;i++){
            Class<?> returnType = ms[i].getReturnType();
            Class<?> paramTypes[] = ms[i].getParameterTypes();
            int modifier = ms[i].getModifiers();
            System.out.print(Modifier.toString(modifier)+" ");
            System.out.print(returnType+" ");
            System.out.print(ms[i].getName());
            System.out.print("(");
            for (int x = 0; x < paramTypes.length;x++){
                System.out.print(paramTypes[x].getName()+" "+"arg"+x);
                if (x < paramTypes.length - 1){
                    System.out.print(",");
                }
            }

            // 得到方法的异常
            Class<?> exs[] = ms[i].getExceptionTypes();
            if (exs.length > 0){
                System.out.print(") throws");
            }else {
                System.out.print(")");
            }
            for (int j = 0; j < exs.length; j++){
                System.out.print(exs[j].getName());
                if (j < exs.length - 1){
                    System.out.print(",");
                }
            }
            System.out.print("\n");
        }
    }

}


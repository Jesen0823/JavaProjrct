package design_patterns_2.create.staticfactory.demo2;

import javabasereview.ProUtil;

import java.util.Properties;

/**
 * 反射在工厂模式的应用
 * 通过工厂类获取对象时，传入产品完整的包名,包名用了属性配置文件
 * 优点：无论增加多少子类产品，工厂类都不用修改
 * */
public class UseReflectFactoryDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Properties pro = ProUtil.getPro();
        if (pro != null && pro.getProperty("apple")!= null) {
            Fruit f = Factory.getInstance(pro.getProperty("apple"));
            if (f != null) {
                f.eat();
            }
        }
    }
}

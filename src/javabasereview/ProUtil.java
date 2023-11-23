package javabasereview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ProUtil {

    private static final String FRUIT_PROPERTIES_PATH =
            "D:\\Java\\JavaProjrct\\src\\javabasereview\\reflect\\fruit.properties";

    public static void printLine() {
        System.out.println("************************************************");
    }

    public static Properties getPro() {
        Properties pro = new Properties();
        File file = new File(FRUIT_PROPERTIES_PATH);
        try {
            if (file.exists() && file.length() != 0) {
                pro.load(new FileInputStream(file));
            } else {
                pro.setProperty("apple", "design_patterns_2.create.staticfactory.demo2.factorymode.Apple");
                pro.setProperty("orange", "design_patterns_2.create.staticfactory.demo2.factorymode.Orange");
                pro.store(new FileOutputStream(file), "FRUIT_CLASS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }
}



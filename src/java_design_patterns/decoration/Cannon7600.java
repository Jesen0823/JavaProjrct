package java_design_patterns.decoration;

/**
 * 打印机实现类 佳能7600
 * */
public class Cannon7600 extends Printer {
    @Override
    public void print() {
        System.out.println("佳能7600 --打印文件");
    }
}

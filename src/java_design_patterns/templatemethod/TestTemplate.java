package java_design_patterns.templatemethod;

/**
 * 模板方法模式
 * <p>
 * 定义：定义一个操作中的算法框架，而将一些步骤延迟到子类中，使得子类不改变一个算法的结构即可重定义算法的某些特定步骤。
 * <p>
 * 模板方法实际就是封装固定的流程，像模板一样，第一步做什么，第二步又做什么，都在抽象类中定义好。子类可以有不同的算法实现，在算
 * 法框架不被修改的前提下实现某些步骤的算法替换。
 * <p>
 * ·使用场景：
 * 多个子类有共有的方法，并且逻辑基本相同时。面对重要、复杂的算法，可以把核心算法设计为模板方法，周边相关
 * 细节功能则由各个子类实现。
 * 需要通过子类来决定父类算法中的某个步骤是否执行，实现子类对父
 * 类的反向控制。
 * <p>
 * ・优点：
 * 模板方法模式通过忽不变的行为搬移到超类，去除了子类中的重复代码。子类实现算法的某些细节，有助于算法的扩展。
 * <p>
 * ・缺点：
 * 每个不同的实现都需要定义一个子类，这会导致类的个数的增加，设计更加抽象。
 */
public class TestTemplate {

    public static void main(String[] args) {
        System.out.println("<条形码扫描>:");
        BarCodeSweep barCode = new BarCodeSweep();
        barCode.sweep();

        System.out.println("<二维码扫描>:");
        QrCodeSweep qrCode = new QrCodeSweep();
        qrCode.sweep();
    }
}

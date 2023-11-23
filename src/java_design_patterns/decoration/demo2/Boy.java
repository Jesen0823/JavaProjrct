package java_design_patterns.decoration.demo2;

/**
 * 只穿了内衣，功能单一，需要被修饰
 */
public class Boy extends Person {
    @Override
    public void dress() {
        System.out.println("穿内衣");
    }
}

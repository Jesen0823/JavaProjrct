package java_design_patterns.proxy.dynamic;

public class Consumer implements IShop {
    @Override
    public void buy() {
        System.out.println("顾客购买");
    }
}

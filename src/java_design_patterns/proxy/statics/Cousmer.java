package java_design_patterns.proxy.statics;

public class Cousmer implements IShop {
    @Override
    public void buy() {
        System.out.println("顾客购买");
    }
}

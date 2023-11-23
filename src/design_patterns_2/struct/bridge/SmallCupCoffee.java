package design_patterns_2.struct.bridge;

public class SmallCupCoffee extends Coffee {

    public SmallCupCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("制作 小杯" + impl);
    }
}

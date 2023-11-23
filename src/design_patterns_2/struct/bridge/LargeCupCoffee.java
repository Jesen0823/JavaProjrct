package design_patterns_2.struct.bridge;

public class LargeCupCoffee extends Coffee {

    public LargeCupCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("制作 大杯" + impl);
    }
}

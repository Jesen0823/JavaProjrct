package design_patterns_2.create.factoryfunction;

public class CoffeeCup extends ProductCup {
    @Override
    public void put() {
        System.out.println("装入咖啡");
    }
}

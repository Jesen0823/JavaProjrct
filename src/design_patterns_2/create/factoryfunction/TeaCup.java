package design_patterns_2.create.factoryfunction;

public class TeaCup extends ProductCup {
    @Override
    public void put() {
        System.out.println("装入红茶");
    }
}

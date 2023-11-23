package design_patterns_2.struct.bridge;

public abstract class Coffee {
    protected CoffeeAdditives impl;

    public Coffee(CoffeeAdditives impl){
        this.impl = impl;
    }

    // 制作咖啡
    public abstract void makeCoffee();
}

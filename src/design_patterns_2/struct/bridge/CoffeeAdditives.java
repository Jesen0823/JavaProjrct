package design_patterns_2.struct.bridge;

/**
 * 咖啡添加物
 */
public abstract class CoffeeAdditives {

    public abstract String addSomething();

    @Override
    public String toString() {
        return addSomething();
    }
}

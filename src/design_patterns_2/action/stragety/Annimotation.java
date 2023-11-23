package design_patterns_2.action.stragety;

public class Annimotation {

    private InterpolatorStrategy strategy;

    public void setStrategy(InterpolatorStrategy strategy) {
        this.strategy = strategy;
    }

    public void start(){
        strategy.draw();
        System.out.println("，动画开始");
    }
}

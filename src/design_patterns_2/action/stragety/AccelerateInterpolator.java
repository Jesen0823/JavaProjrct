package design_patterns_2.action.stragety;

public class AccelerateInterpolator implements InterpolatorStrategy{
    @Override
    public void draw() {
        System.out.println("加速减速插值器");
    }
}

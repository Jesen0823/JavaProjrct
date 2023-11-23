package design_patterns_2.action.stragety;

public class LinearInterpolator implements InterpolatorStrategy{
    @Override
    public void draw() {
        System.out.println("线性插值器");
    }
}

package java_design_patterns.bridge;

import design_patterns_2.action.command.c2.android.Canvas;
import java_design_patterns.bridge.android.View;

public class CircleProgressBar extends BaseProgressBar {
    @Override
    public int getMeasureHeight() {
        return 400;
    }

    @Override
    public int getMeasureWidth() {
        return 400;
    }

    @Override
    public void draw(View view, Canvas canvas) {
        System.out.println("绘制圆形进度条");
    }
}

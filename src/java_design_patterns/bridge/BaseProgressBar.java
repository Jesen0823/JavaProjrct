package java_design_patterns.bridge;

import design_patterns_2.action.command.c2.android.Canvas;
import design_patterns_2.action.command.c2.android.Paint;
import java_design_patterns.bridge.android.View;


public abstract class BaseProgressBar {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int CIRCLE = 2;

    protected Paint mPaint;

    protected BaseProgressBar(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
    }

    public abstract int getMeasureHeight();

    public abstract int getMeasureWidth();

    public abstract void draw(View view, Canvas canvas);
}

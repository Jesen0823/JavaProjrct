package java_design_patterns.bridge.android;

import design_patterns_2.action.command.c2.android.Canvas;

public abstract class View {

    protected abstract void onMeasure(int widthMeasureSpec,int heightMeasureSpec);

    public void setMeasureDimension(int size){

    }

    protected abstract void onDraw(Canvas canvas);
}

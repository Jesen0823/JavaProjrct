package java_design_patterns.bridge;

import design_patterns_2.action.command.c2.android.Canvas;
import java_design_patterns.bridge.android.MeasureSpec;
import java_design_patterns.bridge.android.View;

public class Progressbar extends View {
    private int style = BaseProgressBar.CIRCLE;
    public static final int WIDTH = 1;
    public static final int HEIGHT = 3;
    private BaseProgressBar mBaseProgressBar;

    public Progressbar(){
        // context,AttributeSet...
        // TypedArray, R.styleable.Progressbar
        if (style == BaseProgressBar.CIRCLE){
            mBaseProgressBar = new CircleProgressBar();
        }else if (style == BaseProgressBar.HORIZONTAL){
            mBaseProgressBar = new HorizontalProgressBar();
        }else {
            mBaseProgressBar = new VerticalProgressBar();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasureDimension(measureDimension(WIDTH,widthMeasureSpec));
        measureDimension(HEIGHT,heightMeasureSpec);
    }

    private int measureDimension(int type,int measureSpec){
        if (style == BaseProgressBar.CIRCLE){
            return mBaseProgressBar.getMeasureWidth();
        }
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.EXACTLY){
            result = size;
        }else {
            if (type==HEIGHT){
                result  = mBaseProgressBar.getMeasureHeight();
            }else {
                result = mBaseProgressBar.getMeasureWidth();
            }
            if (mode == MeasureSpec.AT_MOST){
                result = Math.min(result,size);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBaseProgressBar.draw(this,canvas);
    }
}

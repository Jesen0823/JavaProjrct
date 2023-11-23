package design_patterns_2.action.command.c2;

import design_patterns_2.action.command.c2.android.Canvas;
import design_patterns_2.action.command.c2.android.Paint;
import design_patterns_2.action.command.c2.android.Path;

public class DrawPathCmd implements IDrawCmd{
    public Path path;
    public Paint paint;

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path,paint);
    }

    @Override
    public void undo() {

    }
}

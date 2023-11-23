package design_patterns_2.action.command.c2;

import design_patterns_2.action.command.c2.android.Path;

public class CircleBrush implements IBrush{
    @Override
    public void down(Path path, float x, float y) {

    }

    @Override
    public void move(Path path, float x, float y) {
        path.addCircle(x,y,8,Path.Direction.CW);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}

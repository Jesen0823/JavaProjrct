package design_patterns_2.action.command.c2;


import design_patterns_2.action.command.c2.android.Path;

public class NormalBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
        path.moveTo(x,y);
    }

    @Override
    public void move(Path path, float x, float y) {
        path.lineTo(x,y);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}

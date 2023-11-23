package design_patterns_2.action.command.c2;


import design_patterns_2.action.command.c2.android.Path;

public interface IBrush {

    /**
     * 触点解除时
     */
    void down(Path path, float x, float y);

    /**
     * 触点移动
     */
    void move(Path path, float x, float y);

    /**
     * 触点抬起
     */
    void up(Path path, float x, float y);
}

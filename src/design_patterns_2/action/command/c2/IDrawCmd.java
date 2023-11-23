package design_patterns_2.action.command.c2;

import design_patterns_2.action.command.c2.android.Canvas;

/**
 * 抽象命令
 */
public interface IDrawCmd {

    void draw(Canvas canvas);

    /**
     * 撤销
     */
    void undo();
}

package design_patterns_2.action.command.c2;

import design_patterns_2.action.command.c2.android.Canvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawer {
    // 绘制记录
    private List<DrawPathCmd> drawList = Collections.synchronizedList(new ArrayList<DrawPathCmd>());
    // 重做列表
    private List<DrawPathCmd> redoList = Collections.synchronizedList(new ArrayList<>());

    public void add(DrawPathCmd cmd) {
        redoList.clear();
        drawList.add(cmd);
    }

    /**
     * 撤销上一步
     */
    public void undo() {
        if (drawList.size() > 0) {
            DrawPathCmd undo = drawList.get(drawList.size() - 1);
            drawList.remove(drawList.size() - 1);
            undo.undo();
            redoList.add(undo);
        }
    }

    public void redo() {
        if (redoList.size() > 0) {
            DrawPathCmd redoCmd = redoList.get(redoList.size()-1);
            redoList.remove(redoList.size()-1);
            drawList.add(redoCmd);
        }
    }

    public void execute(Canvas canvas){
        if (drawList!=null){
            for(DrawPathCmd cmd:drawList){
                cmd.draw(canvas);
            }
        }
    }

    /**
     * 是否可重做
     */
    public boolean canRedo(){
        return redoList.size()>0;
    }

    /**
     * 是否可撤销
     */
    public boolean canUndo(){
        return drawList.size()>0;
    }
}

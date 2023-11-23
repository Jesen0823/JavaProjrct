package design_patterns_2.action.command.c1;
/**
 * 格罗斯方块
 * */
public class TetrisMachine {

    public void toLeft(){
        System.out.println("<-");
    }

    public void toRight(){
        System.out.println("->");
    }

    public void fastDown(){
        System.out.println("↓");
    }

    public void transform(){
        System.out.println("变换样式");
    }
}

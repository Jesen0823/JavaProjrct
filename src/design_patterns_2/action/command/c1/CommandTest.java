package design_patterns_2.action.command.c1;
/**
 * 需要抽象出待执行的动作，然后以参数的形式提供出来——类似于过程设计中的回调机制，而
 * 命令模式正是回调机制的一个面向对象的替代品。
 * 命令模式的好处也非常多，更弱的耦合性、更灵活的控制性可扩展性
 * */
public class CommandTest {

    public static void main(String[] args) {
        TetrisMachine machine = new TetrisMachine();

        LeftCommand leftCommand = new LeftCommand(machine);
        RightCommand rightCommand = new RightCommand(machine);
        FastDownCommand fastDownCommand = new FastDownCommand(machine);
        TransformCommand transformCommand = new TransformCommand(machine);

        Button button = new Button();
        button.setLeftCommand(leftCommand);
        button.setRightCommand(rightCommand);
        button.setTransformCommand(transformCommand);
        button.setDownCommand(fastDownCommand);

        button.toDown();
        button.toDown();
        button.toLeft();
        button.toRight();
    }
}

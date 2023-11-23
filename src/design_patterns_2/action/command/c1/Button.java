package design_patterns_2.action.command.c1;
/**
 * 俄罗斯方块按键
 * */
public class Button {
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private FastDownCommand downCommand;
    private TransformCommand transformCommand;
    private StringBuilder text;

    public Button(){
        text = new StringBuilder(" V ");
        System.out.println(text);
    }


    public void toLeft(){
        String old = text.replace(0,1,"").toString();
        text = new StringBuilder(old);
        leftCommand.execute();
        System.out.println(text);
    }
    public void toRight(){
        String old = text.toString();
        text = new StringBuilder(" ").append(old);
        rightCommand.execute();
        System.out.println(text);
    }
    public void toDown(){
        text.append("\n");
        downCommand.execute();
        System.out.println(text);
    }
    public void transform(){
        transformCommand.execute();
        System.out.println(text);
    }

    public void setDownCommand(FastDownCommand downCommand) {
        this.downCommand = downCommand;
    }

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setTransformCommand(TransformCommand transformCommand) {
        this.transformCommand = transformCommand;
    }
}

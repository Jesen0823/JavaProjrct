package design_patterns_2.action.command.c1;

public class RightCommand implements Command{

    private TetrisMachine machine;

    public RightCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toRight();
    }
}

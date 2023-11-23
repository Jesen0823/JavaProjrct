package design_patterns_2.action.command.c1;

public class LeftCommand implements Command{

    private TetrisMachine machine;

    public LeftCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toLeft();
    }
}

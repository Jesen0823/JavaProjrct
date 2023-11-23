package design_patterns_2.action.command.c1;

public class TransformCommand implements Command{

    private TetrisMachine machine;

    public TransformCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.transform();
    }
}

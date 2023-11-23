package design_patterns_2.action.command.c1;

public class FastDownCommand implements Command{

    private TetrisMachine machine;

    public FastDownCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.fastDown();
    }
}

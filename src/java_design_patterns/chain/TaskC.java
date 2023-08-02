package java_design_patterns.chain;

public class TaskC extends BaseTask{

    public TaskC(boolean canDo, String id) {
        super(canDo, id);
    }

    @Override
    public void doAction() {
        System.out.println("task "+getTaskId()+" doing...");
    }
}

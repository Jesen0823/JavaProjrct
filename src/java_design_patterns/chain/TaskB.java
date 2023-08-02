package java_design_patterns.chain;

public class TaskB extends BaseTask {

    public TaskB(boolean canDo, String id) {
        super(canDo, id);
    }

    @Override
    public void doAction() {
        System.out.println("task "+getTaskId()+" doing...");
    }
}

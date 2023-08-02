package java_design_patterns.chain;

public class TaskA extends BaseTask {

    public TaskA(boolean canDo,String id) {
        super(canDo,id);
    }

    @Override
    public void doAction() {
        System.out.println("task "+getTaskId()+" doing...");
    }
}

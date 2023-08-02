package java_design_patterns.chain;

public class TaskD extends BaseTask{

    public TaskD(boolean canDo, String id) {
        super(canDo, id);
    }

    @Override
    public void doAction() {
        System.out.println("task "+getTaskId()+" doing...");
    }
}

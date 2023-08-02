package java_design_patterns.chain;

/**
 * 责任链模式
 */
public abstract class BaseTask {
    // 当前节点有没有能力执行当前任务
    private boolean canDo;
    private BaseTask nextTask;
    private String taskId;

    public BaseTask(boolean canDo,String id) {
        this.canDo = canDo;
        this.taskId = id;
    }

    public void addNextTask(BaseTask nextTask) {
        this.nextTask = nextTask;
    }

    public abstract void doAction();

    public void action() {
        if (canDo) {
            System.out.println(taskId + " can do it.");
            doAction();
            System.out.println(taskId + " can do it and finally finished.");
        } else {
            System.out.println(taskId + " can not do it.");
            // 给下一个节点
            if (nextTask != null) {
                System.out.println(taskId + " give up task and push to next node: " + nextTask.taskId);
                nextTask.action();
            }
        }
    }

    public String getTaskId() {
        return taskId;
    }
}

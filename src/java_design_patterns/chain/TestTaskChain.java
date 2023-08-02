package java_design_patterns.chain;

public class TestTaskChain {

    public static void main(String[] args) {
        TaskA taskA = new TaskA(false,"A");
        TaskB taskB = new TaskB(false,"B");
        TaskC taskC = new TaskC(true,"C");
        TaskD taskD = new TaskD(true,"D");

        taskA.addNextTask(taskB);
        taskB.addNextTask(taskD);
        taskD.addNextTask(taskC);

        taskA.action();
    }
}

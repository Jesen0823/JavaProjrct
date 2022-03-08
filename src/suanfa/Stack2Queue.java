package suanfa;

import java.util.Stack;

/**
 * 用栈实现队列效果
 * */
public class Stack2Queue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 添加元素到队列
     *
     * @param num
     * @return
     */
    public Integer add(Integer num) {
        return stack1.push(num);
    }

    /**
     * 队列弹出元素
     *
     * @return
     */
    public Integer poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }
        // 先判断 stack2
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        // 将 stack1 的元素放入 stack2
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }


    public static void main(String[] args) {
        Stack2Queue queue = new Stack2Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.poll();
        queue.add(5);
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}

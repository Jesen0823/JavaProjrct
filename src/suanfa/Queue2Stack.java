package suanfa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * */
public class Queue2Stack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public boolean push(Integer e){
        return q1.offer(e);
    }

    public Integer pop(){
        if (q1.isEmpty() && q2.isEmpty()){
            return null;
        }

        if (!q1.isEmpty()){
            for (int i = 0; i < q1.size() - 1; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }else {
            for (int i = 0; i < q2.size() -1; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    public int size(){
        return q1.size() + q2.size();
    }

    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        // 入栈一个6
        stack.push(6);
        System.out.println("出栈： "+stack.pop()+ "\n 说明先入后出");
    }
}

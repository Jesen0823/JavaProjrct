package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.TrNode;

import java.util.Stack;

/**
 * 不用递归完成二叉树的 先序、中序、后序遍历
 *
 * */
public class Tree2XStack {

    /**
     *先序遍历非递归
     *
     * 1.准备一个栈，头节点先入栈
     * 2.从栈弹出一个节点，记作cur
     * 3. 打印cur
     * 4.cur有左右child,先右再左压入栈
     * 5. 重复 2,3,4
     * */
    public static void preOrderNoRecur(TrNode head) {
        if (head == null) {
            return;
        }
        Stack<TrNode> stack = new Stack<TrNode>();
        stack.add(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.print(head.value+", ");
            if (head.right!=null){
                stack.push(head.right);
            }
            if (head.left!=null){
                stack.push(head.left);
            }
        }
    }

    /**
     * 后序遍历非递归
     *
     * 1.准备两个栈，头节点先入栈1
     * 2.从栈1弹出一个节点，记作cur
     * 3.cur再入栈2
     * 4.如果cur有左右child,先左再右压入栈1
     * 5. 重复 2,3,4
     * 6. 最后栈2边出栈边打印
     * */
    public static void afterOrderNoRecur(TrNode head) {
        if (head == null) {
            return;
        }
        Stack<TrNode> s1 = new Stack<TrNode>();
        Stack<TrNode> s2 = new Stack<TrNode>();
        s1.push(head);
        while (!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if (head.left!=null){
                s1.push(head.left);
            }
            if (head.right!=null){
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.print(s2.pop().value+", ");
        }
    }

    /**
     * 中序遍历非递归
     *
     * 1.准备1个栈，整个树左边界先入栈
     * 2.从栈弹出一个节点，记作cur并打印
     * 3.cur如果有右子树，该子树所有左边界也全入栈
     * 4.重复 2,3
     * */
    public static void midOrderNoRecur(TrNode head) {
        if (head == null) {
            return;
        }
        Stack<TrNode> s = new Stack<TrNode>();
        while (!s.isEmpty()|| head!=null){
            if (head!=null){
                s.push(head);
                head = head.left;
            }else {
                head = s.pop();
                System.out.print(head.value+", ");
                head = head.right;
            }
        }
    }

    public static void main(String[] args) {
        TrNode head = new TrNode(1);
        TrNode node2 = new TrNode(2);
        TrNode node3 = new TrNode(3);
        TrNode node4 = new TrNode(4);
        TrNode node5 = new TrNode(5);
        TrNode node6 = new TrNode(6);
        TrNode node7 = new TrNode(7);

        head.left = node2;
        head.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("先序遍历：");
        preOrderNoRecur(head);
        System.out.println(" \n中序遍历：");
        midOrderNoRecur(head);
        System.out.println(" \n后序遍历：");
        afterOrderNoRecur(head);
    }
}


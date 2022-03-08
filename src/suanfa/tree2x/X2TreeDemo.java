package suanfa.tree2x;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class X2TreeDemo {

    public static class Node<T> {
        T value;
        Node<Integer> left;
        Node<Integer> right;

        public Node(T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setLeft(Node<Integer> left) {
            this.left = left;
        }

        public void setRight(Node<Integer> right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        /***********************
         *        12
         *      /    \
         *     7      8
         *    / \    / \
         *   6  11  3   5
         *  /     /  \
         * 9     4  10
         ***********************
         * */
        Node<Integer> head = new Node<>(12);
        Node<Integer> t1 = new Node<>(7);
        Node<Integer> t2 = new Node<>(8);
        Node<Integer> t3 = new Node<>(6);
        Node<Integer> t4 = new Node<>(11);
        Node<Integer> t5 = new Node<>(3);
        Node<Integer> t6 = new Node<>(5);
        Node<Integer> t7 = new Node<>(9);
        Node<Integer> t8 = new Node<>(4);
        Node<Integer> t9 = new Node<>(10);

        head.left = t1;
        head.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t5.left = t8;
        t5.right = t9;

        //System.out.println("递归先序：");
        //pre(head);
        //System.out.println("栈辅助先序：");
        //preOrderUnRecur(head);
        //System.out.println("\n");
        in(head);
        System.out.println("\n");
        inOrderUnRecur(head);
        //System.out.println("\n");
        //pos(head);
        //System.out.println("\n");
        //postOrderUnRecur(head);
        System.out.println("\n");
        //widthOrder(head);
        int maxWidth = widthOrderAndGetMaxWidth(head);
        System.out.println("max len: " + maxWidth);
        int maxWidth2 = widthOrderAndGetMaxWidthNoMap(head);
        System.out.println("max len2: " + maxWidth2);
    }

    /**
     * 先序遍历，也叫深度优先遍历
     * 每一棵树都是按头，左，右的顺序遍历:
     */
    public static void pre(Node<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历
     * 每一棵树，按 左，头，右的顺序打印
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + " ");
        in(head.right);
    }

    /**
     * 后序遍历
     * 每棵树按 左右头的顺序
     */
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 先序的非递归实现：
     * 1. 先将头节点入栈
     * 2. 弹出栈中的节点cur
     * 3. 将该节点的右child入栈，再左child入栈(如果有)
     * 4. 出栈一个，然后重复3步骤
     */
    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 后序的非递归实现
     * 1. 准备栈Stack 和 收集栈 lastStack
     * 2. 将头节点入Stack
     * 3. Stack出栈放入 lastStack
     * 4. 被出栈节点的child先左再右入Stack(如果有)
     * 5.重复4,5步骤
     * 6. lastStack依次出栈就是结果
     */
    public static void postOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            Stack<Node> lastStack = new Stack<Node>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                lastStack.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!lastStack.isEmpty()) {
                System.out.print(lastStack.pop().value + " ");
            }
        }
    }

    /**
     * 中序的非递归实现
     * 1. 准备栈Stack
     * 2. 将头节点下所有子树左child入栈
     * 3. 出栈一个，如果该节点有右child,该右child入栈
     * 4.重复3步骤
     */
    public static void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 宽度优先遍历
     * 1. 准备一个队列
     * 2. 头节点head进入队列
     * 3. child先左再右依次进入队列
     * 4. 出队列一个节点，然后重复3，4步骤
     */
    public static void widthOrder(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 宽度优先遍历， 并求最大宽度
     * 使用hashMap
     */
    public static int widthOrderAndGetMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;  // 当前正在统计哪一层
        int curLevelNodes = 0; // curLevel层宽度目前是多少
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 当前节点所属的层次
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                queue.add(cur.left);
                levelMap.put(cur.left, curNodeLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                levelMap.put(cur.right, curNodeLevel + 1);
            }
            // 说明还在当前层遍历
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        // 因为每次max的判断都是等到上一层的结束才进行，
        // 因此等到while循环结束之后再次进行一次判断
        return Math.max(max, curLevelNodes);
    }

    /**
     * 宽度优先遍历， 并求最大宽度
     * 不使用hashMap
     */
    public static int widthOrderAndGetMaxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head; // 当前层最右节点是谁
        Node nextEnd = null; // 下一层最右节点是谁
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}

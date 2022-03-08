package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.TrNode;

/**
 * 二叉树节点结构
 * class Node<V>{
 *  V value;
 *  Node left;
 *  Node right;
 * }
 * 叶子节点：左右child都为空的节点
 * ===========================================
 * 用递归和非递归两种方式实现二叉树的先序、中序、后序遍历
 * 如何直观的打印一颗二叉树
 * 如何完成二叉树的宽度优先遍历（常见题目：求一棵二叉树的宽度）*/
public class Tree2XDiGui {

    // 二叉树递归遍历模型
    public static void f(TrNode head){
        if (head == null){
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    public static void preOrderRecur(TrNode head){
        if (head == null){
            return;
        }
        System.out.print(head.value+", ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void midOrderRecur(TrNode head){
        if (head == null){
            return;
        }
        midOrderRecur(head.left);
        System.out.print(head.value+", ");
        midOrderRecur(head.right);
    }

    public static void afterOrderRecur(TrNode head){
        if (head == null){
            return;
        }

        afterOrderRecur(head.left);
        afterOrderRecur(head.right);
        System.out.print(head.value+", ");
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
        preOrderRecur(head);
        System.out.println(" \n中序遍历：");
        midOrderRecur(head);
        System.out.println(" \n后序遍历：");
        afterOrderRecur(head);
    }
}

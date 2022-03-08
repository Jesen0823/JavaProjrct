package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.TrNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * <p>
 * 就是内存里的一棵树如何变成字符串形式，又如何从字符串形式变成内存里的树
 * <p>
 * 如：
 * ①
 * /  \
 * null   ①
 * / \
 * ①  null
 * / \
 * null null
 * <p>
 * 中序遍历：
 * ①_#_①_①_#_#_#_  其中下划线表示节点数据结束，#表示 null
 * <p>
 * <p>
 * 如何判断一颗二叉树是不是另一棵二叉树的子树？
 */
public class SerilizalBinaryTree {

    /**
     * 先序 序列化一棵树成字符串
     */
    public static String serialTreePre(TrNode head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialTreePre(head.left);
        res += serialTreePre(head.right);
        return res;
    }

    public static TrNode reconTreePreToString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i !=values.length ; i++) {
            queue.add(values[i]);
        }
        return reconTreePre(queue);
    }

    private static TrNode reconTreePre(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TrNode head = new TrNode(Integer.valueOf(value));
        head.left = reconTreePre(queue);
        head.right = reconTreePre(queue);
        return head;
    }

    public static void main(String[] args) {
        TrNode head = new TrNode(4);
        TrNode node3 = new TrNode(3);
        TrNode node8 = new TrNode(8);
        TrNode node9 = new TrNode(9);
        TrNode node91 = new TrNode(9);
        TrNode node11 = new TrNode(11);
        TrNode node10 = new TrNode(10);
        TrNode node12 = new TrNode(12);
        TrNode node21 = new TrNode(21);

        head.left = node3;
        head.right = node91;
        node3.left = node8;
        node3.right = node9;
        node9.right = node11;
        node11.left = node10;
        node11.right = node12;
        node12.right=node21;
        /**
                   4
                 /  \
                3    9
               / \
              8   9
                   \
                   11
                   / \
                  10  12
                       \
                       21
         */

        System.out.println("先序遍历：");
        preOrderRecur(head);
        System.out.println("\n序列化：");
        String res = serialTreePre(head);
        System.out.println(res);
        System.out.println("反序列化：");
        TrNode recon = reconTreePreToString(res);
        preOrderRecur(recon);
    }

    /**
     * 先序遍历打印
     * */
    public static void preOrderRecur(TrNode head){
        if (head == null){
            return;
        }
        System.out.print(head.value+", ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}

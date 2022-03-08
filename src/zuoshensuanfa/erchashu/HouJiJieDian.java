package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.JNode;

/**
 * 在二叉树中找到一个节点的后继节点
 * 与后继节点对应的是前继节点
 *
 * 【题目】现在有一种新的二叉树节点类型如下：
 *
 * public class Node{
 *      public int value;
 *      public Node left;
 *      public Node right;
 *      public Node parent;
 *
 *      public Node(int val){
 *        value = val;
 *      }
 * }
 *
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向自己的父节点，头节
 * 点的parent指向null。
 * 只给一个在二叉树中的某个节点node,请实现返回node的后继节点的函数。
 * 在二叉树的中序遍历的序列中，node的下一个节点叫作node的后继节点。
 *
 * 假设找node后继：
 * 1) node有右树，后继是它右树的最左节点
 * 2）无右子树，往上找，后继是父节点
 *
 * */

public class HouJiJieDian {

    public static JNode getHouJiNode(JNode node){
        if (node == null){
            return node;
        }
        if (node.right!=null){ // 有右子树
            return getHouJiNode(node.right);
        }else { // 无右子树
            JNode parent = node.parent;
            // 当前节点是它father的右child
            while (parent!=null&& parent.left!=node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // 找node的左节点
    public static JNode hetLeftMost(JNode node){
        if (node == null){
            return node;
        }
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }


}

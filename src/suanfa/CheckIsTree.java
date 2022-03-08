package suanfa;

import suanfa.utils.TreeNode;

/**
 * 5
 * /  \
 * 1     4
 * /  \
 * 3    6
 * 检查二叉树是否符合规则，左小右大的规则
 * <p>
 *     5
 *    /  \
 *  1     6
 *      /  \
 *      3    7
 */
public class CheckIsTree {
    public static TreeNode pre = null;

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node4 = new TreeNode(4, node3, node6);
        TreeNode root = new TreeNode(5, node1, node4);

        boolean result = isValidBST(root);
        System.out.println("二叉树检查 result: " + result);

        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n6 = new TreeNode(6, n3, n7);
        TreeNode nr = new TreeNode(5, n1, n6);

        boolean result2 = isValidBST(nr);
        System.out.println("二叉树检查 result2: " + result2);
    }


    public static boolean helper(TreeNode root) {
        //如果结点为空，直接返回true
        if (root == null) {
            return true;
        }
        if (helper(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        return helper(root.right);
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root);
    }
}

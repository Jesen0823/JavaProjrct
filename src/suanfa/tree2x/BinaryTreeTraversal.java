package suanfa.tree2x;
/**
 * 二叉树的前序遍历、中序遍历和后序遍历是常见的树遍历方式，它们之间的区别和记忆可以通过以下方法进行区分：
 *
 * 前序遍历（Preorder Traversal）：首先访问根节点，然后按照前序遍历的顺序递归地遍历左子树，最后递归地遍历右子树。在前序遍历中，根节点的访问顺序在左右子树之前。
 *
 * 记忆提示：前序遍历可以记作「根-左-右」，即先访问根节点，然后依次遍历左子树和右子树。
 *
 * 中序遍历（Inorder Traversal）：先按照中序遍历的顺序递归地遍历左子树，然后访问根节点，最后递归地遍历右子树。在中序遍历中，根节点的访问顺序在左右子树之间。
 *
 * 记忆提示：中序遍历可以记作「左-根-右」，即先遍历左子树，然后访问根节点，最后遍历右子树。
 *
 * 后序遍历（Postorder Traversal）：先按照后序遍历的顺序递归地遍历左子树，然后递归地遍历右子树，最后访问根节点。在后序遍历中，根节点的访问顺序在左右子树之后。
 *
 * 记忆提示：后序遍历可以记作「左-右-根」，即先遍历左子树，然后遍历右子树，最后访问根节点。
 *
 * 前中后，说的是根节点的遍历次序
 * */
public class BinaryTreeTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 前序遍历
    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        /*
        *     1
        *   2   3
        * 4   5
        * */

        BinaryTreeTraversal traversal = new BinaryTreeTraversal();

        System.out.print("前序遍历结果：");
        traversal.preOrderTraversal(root);
        System.out.println();

        System.out.print("中序遍历结果：");
        traversal.inOrderTraversal(root);
        System.out.println();

        System.out.print("后序遍历结果：");
        traversal.postOrderTraversal(root);
        System.out.println();
    }
}


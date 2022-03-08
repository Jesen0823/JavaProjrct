package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.TrNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的相关概念及其实现判断
 * <p>
 * 1. 如何判断一颗二叉树是否是搜索二叉树？
 * 对每一个节点而言，每一颗子树左节点都比他小，右节点比他大。
 * ⑤
 * /   \
 * ③    ⑦
 * /\    /\
 * ② ④  ⑥ ⑧
 * /
 * ①
 * 用中序遍历：1,2,3,4,5,6,7,8, 如果发现降序，就不是搜索二叉树
 * ====================================================
 * 2. 如何判断一颗二叉树是完全二叉树？
 * 完全二叉树是只整棵树是从上到下从左往右，依次排列的，即便最后结尾处不满也算完全二叉树
 * <p>
 * ⑤
 * /   \
 * ③    ⑦
 * /\    /\
 * ② ④  ⑥ ⑧
 * / \
 * ① ⑥
 * 判断：
 * 1) 任意节点的child，如果有右无左，一定不是完全二叉树
 * 2) 满足1的情况下，任意节点若左右child不全，则按宽度优先的顺序他的后序节点一定全是叶节点
 * ====================================================
 * 3. 如何判断一颗二叉树是否是满二叉树？
 * 满二叉树，假设最大深度即高度是L, 总节点数M, 满足等式 M = 2的L次方 -1
 * ====================================================
 * 4. 如何判断一颗二叉树是否是平衡二叉树？（二叉树题目套路）
 * 平衡二叉树，左右子树高度差不能超过1
 */

public class BinaryTreePrority {

    /**
     * 1. 递归中序遍历，判断搜索二叉树
     */
    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBinarySearchTree(TrNode head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = isBinarySearchTree(head.left);
        if (!isLeftBst) {
            return false;
        }

        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return isBinarySearchTree(head.right);
    }

    /**
     * 1. 非递归中序遍历 判断搜索二叉树
     */
    public static boolean isBSTSUseStack(TrNode head) {
        if (head != null) {
            int preValue = Integer.MIN_VALUE;
            Stack<TrNode> stack = new Stack<TrNode>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (head.value <= preValue) {
                        return false;
                    } else {
                        preValue = head.value;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    /**
     * 2. 宽度遍历 判断是否完全二叉树
     */
    public static boolean isCompletelyBinaryTree(TrNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TrNode> queue = new LinkedList<>();
        // 是否遇到了子节点不双全的情况
        boolean leaf = false;
        TrNode l = null;
        TrNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 遇到了左右不双全,且有左或有右,反正不是叶节点 || 有右无左一定不是完全二叉树
                    (leaf && (l != null || r != null))
                            ||
                            (l == null && r != null)
            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 3. 判断满二叉树
     * <p>
     * 需要的信息
     * 1) 高度L
     * 2) 总节点总数M
     * <p>
     * 最后需要满足： M = 2的L次方 -1
     */
    public static class FullInfo {
        public int height;
        public int nodeNum;

        public FullInfo(int h, int num) {
            this.height = h;
            this.nodeNum = num;
        }
    }

    public static boolean isFullTree(TrNode head) {
        if (head == null) {
            return true;
        }
        FullInfo info = fullProcess(head);
        return info.nodeNum == (1 << info.height - 1);
    }

    public static FullInfo fullProcess(TrNode x) {
        if (x == null) {
            return new FullInfo(0, 0);
        }
        FullInfo leftInfo = fullProcess(x.left);
        FullInfo rightInfo = fullProcess(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodeNum = leftInfo.nodeNum + rightInfo.nodeNum + 1;

        return new FullInfo(height, nodeNum);
    }

    /**
     * 4. 判断平衡二叉树
     * <p>
     * 递归套路：假设节点的子树能给节点提供信息, 根据这些信息实施递归
     * <p>
     * 那么平衡二叉树需要满足 "子树都是平衡的" && “两子树高度差 <=1” 两个条件
     * 所以需要提供两个信息：
     * A. 子树是否平衡
     * B. 子树的高度
     * <p>
     * 按照以上两条信息实施递归：
     */
    public static boolean isBalancedTree(TrNode head) {
        return processB(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int h) {
            isBalanced = isB;
            height = h;
        }
    }

    private static ReturnType processB(TrNode x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }

        ReturnType leftInfo = processB(x.left);
        ReturnType rightInfo = processB(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    /**
     * 1. 递归套路 判断一棵树是否搜索二叉树
     * <p>
     * 条件：
     * 1) 左树右树都得是二叉搜索树
     * 2) 左树max值 < 当前节点，右树min值 > 当前节点
     * <p>
     * 按以上两个条件递归
     */

    public static class BstReturnInfo {
        public boolean isBST;
        public int min;
        public int max;

        public BstReturnInfo(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static BstReturnInfo processBSTDG(TrNode x) {
        if (x == null) {
            return null;
        }
        BstReturnInfo leftInfo = processBSTDG(x.left);
        BstReturnInfo rightInfo = processBSTDG(x.right);

        int min = x.value;
        int max = x.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        boolean isBST = true;
        if (leftInfo != null && (!leftInfo.isBST || leftInfo.max >= x.value)) {
            isBST = false;
        }
        if (rightInfo != null && (!rightInfo.isBST || rightInfo.max <= x.value)) {
            isBST = false;
        }

        return new BstReturnInfo(isBST, min, max);
    }
}

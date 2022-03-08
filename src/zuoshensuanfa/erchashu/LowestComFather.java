package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.TrNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 求一个数中指定俩节点的最低公共祖先
 */
public class LowestComFather {

    /**
     * o1和o2一定属于head为头的树
     * 返回o1和o2的最低公共祖先
     *
     * 方法1：
     */
    public static TrNode lowestAncestor1(TrNode head, TrNode o1, TrNode o2) {
        HashMap<TrNode, TrNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<TrNode> set1 = new HashSet<>();
        set1.add(o1);
        TrNode cur = o1;
        // 自己不是自己的father,则说明有父节点
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            // o1往上遍历,走过的路都存在set里
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        // 然后o2往上走，如果set里到达交叉点，则交叉点就是最低公共father
        cur = o2;
        while (cur != fatherMap.get(cur)) {
            cur = fatherMap.get(cur);
            if (set1.contains(cur)) {
                break;
            }
        }
        return cur;
    }
    public static void process(TrNode head, HashMap<TrNode, TrNode> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    /**
     * o1和o2一定属于head为头的树
     * 返回o1和o2的最低公共祖先
     * 方法2：不够直观
     */
    public static TrNode lowestAncestor2(TrNode head, TrNode o1, TrNode o2) {
        if (head == null || head == o1 || head == o2) { // base case
            return head;
        }
        TrNode left = lowestAncestor2(head.left, o1, o2);
        TrNode right = lowestAncestor2(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        //左右两棵树，并不都有返回值
        return left != null ? left : right;
    }
}

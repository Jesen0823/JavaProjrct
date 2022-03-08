package zuoshensuanfa.erchashu;

import zuoshensuanfa.erchashu.bean.TrNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树宽度优先遍历,即一行一行打印
 * 用队列辅助
 * <p>
 * 1. 头节点cur先入队
 * 2. cur出队打印，再看cur先左再右入队
 * 3. 重复2
 */
public class TreeWidthFirst {

    public static void widthFirstTree(TrNode head) {
        if (head == null) {
            return;
        }
        Queue<TrNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TrNode cur = queue.poll();
            System.out.print(cur.value + ", ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static int widthFirstTreeGetMaxWidth(TrNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TrNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TrNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);

        int curLevel = 1;
        int curLevelNodeNum = 0;
        int maxNumLevel = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            TrNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodeNum++;
            } else {
                maxNumLevel = Math.max(maxNumLevel, curLevelNodeNum);
                curLevel++;
                curLevelNodeNum = 1;
            }
            System.out.print(cur.value + ", ");
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return maxNumLevel;
    }
}

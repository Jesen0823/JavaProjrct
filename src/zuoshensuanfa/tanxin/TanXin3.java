package zuoshensuanfa.tanxin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入：
 * 正数数组costs
 * 正数数组profits
 * 正数k
 * 正数m
 * 含义：
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱（利润）
 * k表示你只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：
 * 你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：
 * 你最后获得的最大钱数。
 * <p>
 * 步骤：
 * 1. 按花费最小放入小根堆，假设初始资金是M
 * 2. 把小根堆里所有 <=M的拿出来放入一个按利润的大根堆
 * 3. 大根堆弹出一个，做了，计算资金
 * 4. 继续2,3步
 */
public class TanXin3 {

    public static class Node {
        public int profit;
        public int cost;

        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }

    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }

    }

    public static int findMaximizedCapital(int k, int m, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        // 按花费将项目放入小根堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        // 最多可以做k个项目
        for (int i = 0; i < k; i++) {
            // 现有资金可以做的项目，全入大根堆
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= m) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return m;
            }
            // 累计剩余资金
            m += maxProfitQ.poll().profit;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] cost = {1, 1, 2, 2, 3, 4};
        int[] profits = {1, 4, 3, 7, 2, 10};
        int k = 4;
        int m = 2;
        int result = findMaximizedCapital(k, m, profits, cost);
        System.out.println("最终资金：" + result);
    }

}
